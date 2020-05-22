

var newUser = {

	firstName: "",
	middleName: "",
	lastName: "",
	gender: "",
	ssn: null,
	maritalStatus: "",
	numberOfChildren: null,
	placeOfBirth: "",
	religion: "",
	stateOfOrigin: "",

	"address": {
		street: "",
		city: "",
		state: "",
		postCode: null,
		country: ""
	},

	"dateOfBirth": {
		year: null,
		month: null,
		day: null
	},

	"employment": {
		status: "",
		profession: ""
	},

	"nextOfKin": {
		"name": "",
		"address": {
			street: "",
			city: "",
			state: "",
			postCode: null,
			country: ""
		},

		"contactInfo": {
			phone: null,
			email: ""
		}
	},
	"houseHold": {
		id: null,
		role: ""
	}
};

module.exports = { newUser };

