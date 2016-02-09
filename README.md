# Team 99 - Android Exercise

This is a fun exercise/challenge to help us assess the skill of candidates interested in joining the engineering team at 99.co. If you would like to attempt it, create your own fork and starting coding away!

## Introduction
Building forms to collect information from users is not the most fun thing to do. However, it's a necessary function in most apps. Wouldn't it be awesome if we could write some code that can dynamically generate forms for us? We would never have to worry about it again.

We want your help with that! We're halfway through realising this dream and we need you to take us to the finish line. Here's what we have until now:

### Form Structure
We've come up with a JSON structure to define form contents. You can think of a form as a page consisting of a list of sections. Each section can have a title, a list of rows, and a footer. (title and footer are optional).

Sections can consist of rows of different types. These are the types that are to be supported at this point:

- **Radio:** This row will present the user with a dialog
- **Text:** This row allows the user to input text
- **Checkbox:** This row allows the user to toggle an option on or off

The form templates are available as JSON files in the `/assets` folder.

### JSON Parsers & Model Classes
We have some existing code you can make use of. There's a parser to make sense of the content in the JSON form templates and a set of model classes to represent that information. You can use this code as a start point for your work.

## Exercise
### Part 1: Functional UI
Create a functional user interface for a given form template. Users should be able to see all the information available (titles, footers etc.) and be interact with the individual rows. i.e. be able to input text, choose radio options, and tap on checkboxes.

The objective of this exercise is to assess your understanding of the requirements and your approach. Building a bare bones, functional UI is sufficient! Don't worry too much about things like padding, text size/colour etc. (although it may be tempting!)

### Part 2: Showing/Hiding Sections
Sections can be hidden based on a set of rules. This allows us to hide parts of our UI until the user selects certain options.