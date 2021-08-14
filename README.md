# Team 99 - Android Exercise

This is a fun exercise/challenge to help us assess the skill of candidates interested in joining the engineering team at 99.co. If you would like to attempt it, create your own fork and starting coding away!

## Introduction
Building forms to collect information from users is not the most fun thing to do. However, it's a necessary function in most apps. Wouldn't it be awesome if we could write some code that can dynamically generate forms for us? We would never have to worry about it again.

That is precisely the objective of this exercise. We want your help with that! We're halfway through realising this dream and we need you to take us to the finish line. Here's what we have until now:

### Form Structure
We've come up with a JSON structure to define form contents. You can think of a form as a page consisting of a list of sections. Each section can have a title, a list of rows, and a footer. (title and footer are optional).

Sections can consist of rows of different types. These are the types that are to be supported at this point:

- **Radio:** This row will present the user with a dialog
- **Text:** This row allows the user to input text
- **Checkbox:** This row allows the user to toggle an option on or off

Here's a sample of what our JSON form document looks like:

```javascript
"sections": [{ //Array of sections to be displayed

		"title": "What are you looking for?", //Title for the section (Optional)
		"footer": null, //Footer for the section (Optional)

		"rows": [{ //Array of rows in this section
			"title": "Category", //Title of the row
			"type": "radio", //Row type (radio/checkbox/text)
			"value": "rent", //Default value for the row
			"key": "listing_type", //Unique key identifying this row in this page

			"options": [{ //This field is applicable for a radio row. Contains an array of options that the user can choose from
				"value": "rent", //Value to be stored in the row
				"label": "Rental" //User facing string
			}, {
				"value": "sale",
				"label": "Sale"
			}]
		}, {
            ...
		}]
	},{
    	...
	}
]
```


### JSON Parsers & Model Classes
We have some existing code you can make use of to encapsulate the JSON data described above. There's a parser to make sense of the content in the JSON form templates and a set of model classes to represent that information. You can use this code as a start point for your work.

Call the `getSampleForm(Context context)` method in the `Util` class to get a `Page` object and get going! The `Page` object contains a list of `Section` objects, which each contain a list of `Row` objects. The `Row` class is abstract. Each row type (text, checkbox etc.) has it's own subclass/implementation of the `Row` class. For e.g. the `RowText` class represents a text row, and a `RowRadio` class represents a radio button row.

## Exercise
### Part 1: Functional UI
Create a functional user interface for a given form template. Users should be able to see all the information available (titles, footers etc.) and interact with the individual rows. i.e. be able to input text, choose radio options, and tap on checkboxes.

The objective of this exercise is to assess your understanding of the requirements and your approach. Building a bare bones, functional UI is sufficient! Don't worry too much about things like padding, text size/colour etc. (however tempting it may be!)

**Use the [`part-1`](https://github.com/team99/99-android-exercise/tree/part-1) branch for this exercise.**

### Part 2: Showing/Hiding Sections
Sections can be hidden based on a set of rules. This allows us to hide parts of our UI until the user selects certain options. We define the rules in terms of the values that rows can have. If a section has rules defined, it'll be hidden by default. The section will become visible once the rows have the values that we want.

Add support for showing and hiding sections based on the rules specified. The rules are specified in the section object in this format:

```javascript
Section object:
{
    "title": "What are you looking for?",
    ...
    "visible_conditions": [
        {
            "listing_type": "rent"
        }
    ]
}
```

For e.g., in the code snippet above, we see that a row has a visible condition based on the value in the row with key `listing_type`. This means that this row will be hidden by default until the row with key `listing_type` contains the value `rent`. The `value` for a row is stored in the form of a JsonElement in the `Row` class.

The parser and model classes supplied will parse and evaluate these rules for you. You can call the `isVisible()` method in the `Section` object to know whether the section should be displayed. The `Row` object also contains a boolean field called `hasDependantFormElements` that will tell you if the value of a row can affect the visibility of any sections.

**Use the [`part-2`](https://github.com/team99/99-android-exercise/tree/part-2) branch for this exercise.**

## Getting Started
We require candidates to attempt part-1 of the challenge. If you've successfully completed part-1 and have some spare time on your hands, you're welcome to proceed and attempt part-2 of the exercise! :smiley:

Most of the code provided as part of this challenge relies heavily on Gson, Google's JSON parsing library. You can find more information about Gson [here](https://github.com/google/gson).

Few things to keep in mind:

- It'll be good to commit your work frequently so that we can follow your progress and see how you worked through this problem.
- Having a slick/polished would nice, but not the main focus of this exercise! We would just like to understand more about your approach.



### Language
- Please use Kotlin rather than Java

### Instructions
1. Create your own fork of this repository to get started.
2. Remember to use the branch corresponding to the part of the exercise you're working on. (part-1 for Part 1 and part-2 for part 2)
3. Once you've finished the challenge, grant us access to the fork and send us an APK file that can be installed on devices.
4. Add in any additional instructions we might need to setup the codebase on our local machines.
