//const mysql = require('mysql');
//const bodyParser = require('body-parser'); //Middleware for express
const express = require('express');
const app = express();
const MongoClient = require('mongodb').MongoClient;
const newResister = require("./register.js"); // import object of newUser

const url = "mongodb://localhost:27017";
const port = process.env.PORT || 8005;
//const dbName = 'census_db';
//const dbTable = 'census_table';

//app.use(bodyParser.json());
app.use(express.json());

// Use connect method to connect to the server
MongoClient.connect(url, (err, db) => {

    if (err) {
        console.log("Can not connect")
    } else {
        const databaseDC = db.db('census_db');
        const collection = database.collection(census_table);

        app.post('/registration', (err, res) => {

            const newRegistration = newResister;
            /*{
                
                name: req.body.name,
                address: req.body.address,
                dateOfBirth: req.body.dateOfBirth,
                ssn: req.body.ssn
            }*/
            const query = { ssn: newRegistration.ssn };

            databaseDC.collection.findOne(query, (err, result) => {

                if (result == null) {
                    collection.insertOne(newRegistration, (err, result) => {
                        res.status(200).send();
                    });
                } else {
                    res.status(400).send();
                }
            });

        });

        app.post('/homePage', (req, res) => {

            // create user object and search to login
            const query = {
                name: req.bady.name,
                ssn: req.body.ssn
            }
            databaseDC.collection.findOne(query, (err, result) => {

                if (result != null) {

                    //send to client app the found user
                    const requestObject = {
                        name: result.name,
                        ssn: result.ssn
                    }
                    res.status(200).send(JSON.stringify(requestObject));
                }
                else {
                    res.status(400).send();
                }
            });
        });

    }
});

//PORT to listening
app.listen(port, () => {
    console.log("Listening to port number...", port)
});

/*app.get('/', async (req, res) => {
    res.json({ status: 'Is ready to serve' + process.env.LOCATION });
});*/



/*const personName = {
    url: 'https://reqres.in/api/users',
    json: true,
    body: {
        name: 'Atta',
        job: 'Software Engineer'
    }
};*/