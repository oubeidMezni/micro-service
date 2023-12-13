const express = require('express');
const Eureka = require('eureka-js-client').Eureka;
const { MongoClient, ObjectId } = require('mongodb');

const app = express();
const port = 3000;
// Connection URI
const uri = 'mongodb+srv://anas:anas@cluster0.w2ejoae.mongodb.net/?retryWrites=true&w=majority';
const client = new MongoClient(uri);
// Database and collection names
const dbName = 'db';
const collectionName = 'hebergement';
// Middleware for parsing JSON bodies
app.use(express.json());

app.listen(port, () => {
  console.log(`Express server listening at http://localhost:${port}`);
});

const eureka = new Eureka({
  instance: {
    app: 'Hebergement', // Change this to your service name
    hostName: 'localhost', // Change this to your server's hostname
    ipAddr: '127.0.0.1', // Change this to your server's IP address
    port: {
      '$': 3000,
      '@enabled': 'true',
    },
    vipAddress: 'Hebergement', // Change this to your service name
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
    registerWithEureka: true,
    fetchRegistry: true,
  },
  eureka: {
    host: 'localhost', // Change this to your Eureka server's hostname
    port: 8761, // Change this to your Eureka server's port
    servicePath: '/eureka/apps',
  },
});

eureka.logger.level('debug');

eureka.start(error => {
  if (error) {
    console.log('Eureka registration failed:', error);
  } else {
    console.log('Registered with Eureka');
  }
});

// Create a new hebergament
app.post('/api/hebergement', async (req, res) => {
  try {
    await client.connect();
    const db = client.db(dbName);
    const collection = db.collection(collectionName);
    const result = await collection.insertOne(req.body);
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: error });
  } finally {
    client.close();
  }
});

// Get all hebergament
app.get('/api/hebergement', async (req, res) => {
  try {
    

    await client.connect();
    const db = client.db(dbName);
    const collection = db.collection(collectionName);
    const result = await collection.find({}).toArray();
    //const db = client.db(dbName);
   // const collection = db.collection(collectionName);

   // const result = await collection.find({}).toArray();
    res.json(result);
  } catch (error) {
    res.status(500).json({ error:error });
  } finally {
    client.close();
  }
});

// Get a specific hebergament
app.get('/api/hebergement/:id', async (req, res) => {
  try {
    await client.connect();

    const db = client.db(dbName);
    const collection = db.collection(collectionName);

    const result = await collection.findOne({ _id: new ObjectId(req.params.id) });
    if (result) {
      res.json(result);
    } else {
      res.status(404).json({ error: 'Hebergament not found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Internal server error' });
  } finally {
    client.close();
  }
});

// Update a hebergament
app.put('/api/hebergement/:id', async (req, res) => {
  try {
    await client.connect();

    const db = client.db(dbName);
    const collection = db.collection(collectionName);

    const result = await collection.updateOne(
      { _id: new ObjectId(req.params.id) },
      { $set: req.body }
    );
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: 'Internal server error' });
  } finally {
    client.close();
  }
});

// Delete a hebergament
app.delete('/api/hebergement/:id', async (req, res) => {
  try {
    await client.connect();

    const db = client.db(dbName);
    const collection = db.collection(collectionName);

    const result = await collection.deleteOne({ _id: new ObjectId(req.params.id) });
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: 'Internal server error' });
  } finally {
    client.close();
  }
});
