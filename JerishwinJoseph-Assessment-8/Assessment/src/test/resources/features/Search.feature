Feature: Search for the give keywords 

	Scenario Outline: Searching for the keyords
		Given the user is on the Home page
		When the user searches for the <'keyword'>
		Then the user views the <'result_status'>
		Examples:
			|keyword	|result_status	|
			| iPhone	|contain		|
			| Samsung	|contain		|
			| Nik		|not contain	|