const express = require('express');
const app = express();
const bodyParser = require('body-parser'); //Middleware for express
const mongoose = require('mongoose');


const url = "mongodb://localhost:27017/census_db";
const port = process.env.PORT || 8005;

app.use(bodyParser.json());
app.use(cors());
app.use(
    bodyParser.urlencoded({
        extended: false
    })
)
mongoose.connect(url,
    { useNewUrlParser: true }
)
    .then(() => console.log('Database Connected'))
    .catch(err => console.log(err));

var Persons = require('./routes/Persons')
app.use('/persons', Persons)

app.listen(port, function () {
    console.log('Server is running on port: ' + port)
})
