const express = require('express');
const app = express();
const cors = require('cors');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcrypt');

const census_table = require('../models/Person');
app.use(cors());

process.env.SECRET_KEY = 'secret';

app.post('/register', (req, res) => {

    const today = new Date();
    const personData = {
        firstName: req.body.firstName,
        lastName: req.body.lastName,
        middleName: req.body.middleName,
        gender: req.body.gender,
        dateOfBirth: req.body.dateOfBirth,
        nin: req.body.nin,
        marital: req.body.marital,
        children: req.body.children,
        placeOfBirth: req.body.placeOfBirth,
        religion: req.body.religion,
        stateOfOrigin: req.body.stateOfOrigin,
        address_street: req.body.address_street,
        address_city: req.body.address_city,
        address_state: req.body.address_state,
        address_postCode: req.body.address_postCode,
        address_country: req.body.address_country,
        Created: today
    }

    census_table.findOne({
        nin: req.body.nin
    })
        .then(person => {
            if (!person) {
                bcrypt.hash(req.body.nin, 10, (err, hash) => {
                    personData.nin = hash;
                    census_table.create(personData)
                        .then(person => {
                            res.json({ status: person.nin + 'Registered' });
                        })
                        .catch(err => {
                            res.send('error: ' + err);
                        })
                })
            }
            else {
                res.json({ error: 'Person Already exist' });
            }
        })
        .catch(err => {
            res.send('error: ' + err);
        })
})

app.post('/login', (req, res) => {

    census_table.findOne({
        nin: req.body.nin,
        password: req.body.password //TODO need be created after reqistration
    })
        .then(person => {
            if (person) {
                if (bcrypt.compareSync(req.body.nin, person.nin)) {
                    //nin match
                    const payload = {
                        id: person.id,
                        firstName: person.firstName,
                        lastName: person.lastName
                    }
                    let token = jwt.sign(payload, process.env.SECRET_KEY, {
                        expiresIn: 1550
                    })
                    res.send(token);
                }
                else {
                    // nin NO match
                    res.json({ error: 'Person NOT register' });
                }
            } else {
                res.json({ error: 'Person NOT register' });
            }
        })
        .catch(err => {
            res.send('error: ' + err);
        })
})
app.get('/profile', (req, res) => {
    var decode = jwt.verify(req.headers['authorization'], process.env.SECRET_KEY)

    census_table.findOne({
        id: decode.id
    })
        .then(person => {
            if (person) {
                res.json(person)
            } else {
                res.send('Person NOT exist')
            }
        })
        .catch(err => {
            res.send('error: ' + err)
        })
})
module.exports = app;