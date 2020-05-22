const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const census_table = new Schema({

    id: {
        type: "integer"
    },
    firstName: {
        type: String,
        required: true
    },
    middleName: {
        type: String,
        required: true
    },
    lastName: {
        type: String,
        required: true
    },
    gender: {
        type: String,
        required: true
    },
    dateOfBirth: {
        type: String,
        required: true

    },
    nin: {
        type: String,
        required: true,
        match: [/\S+@\S+\.\S+/, 'is invalid'],
        unique: true
    },
    maritalStatus: {
        type: String,
        required: true
    },
    numberOfChildren: {
        type: String,
        required: true
    },
    placeOfBirth: {
        type: String,
        required: true
    },
    religion: {
        type: String,
        required: true
    },
    stateOfOrigin: {
        type: String,
        required: true
    },
    address: {
        type: Object,
        required: true,

        address_street: {
            type: String,
            required: true
        },
        address_city: {
            type: String,
            required: true
        },
        address_state: {
            type: String,
            required: true
        },
        address_postCode: {
            type: string
        },
        address_country: {
            type: String,
            required: true
        }
    },
    employment: {
        type: Object,
        required: true,

        employment_status: {
            type: String,
            required: true
        },
        employment_profession: {
            type: String,
            required: true
        }
    },
    nextOfKin: {
        type: Object,
        required: true,

        nextOfKin_name: {
            type: String,
            required: true
        },
        nextOfKin_address: {
            type: Object,
            required: true,
            nextOfKin_street: {
                type: String,
                required: true
            },
            nextOfKin_city: {
                type: String,
                required: true
            },
            nextOfKin_state: {
                type: String,
                required: true
            },
            nextOfKin_postCode: {
                type: String
            },
            nextOfKin_country: {
                type: String,
                required: true
            }
        },
        nextOfKin_contact: {
            type: Object,
            required: true,

            nextOfKin_phone: {
                type: String,
                required: true
            },
            nextOfKin_email: {
                type: String,
                required: true
            }
        }
    },
    houseHold: {
        type: Object,
        required: true,

        houseHold_id: {
            type: String
        },
        houseHold_role: {
            type: String,
            required: true
        }
    },
    census: {
        type: Object,
        required: true,

        census_id: {
            type: String,
            required: true
        },
        census_date: {
            type: Date,
            default: Date.now

        }
    }
})
module.exports = mongoose.model('persons', census_table);