# Team 99 - Android Exercise

This is a fun exercise/challenge to help us assess the skill of candidates interested in joining the engineering team at 99.co. If you would like to attempt it, create your own fork and starting coding away!

Duration: ~4 hours

## Introduction

This is a multi module android app with one primary feature - Search. But it is only half way complete and we need your help to get us to the finish line! Here's what we have now:

## Project Configuration
- Language: Kotlin
- Minimum SDK: 16

## Project Structure
- Project will contain the following modules:
    - `app`
    - `core` Kotlin library module
    - `search` dynamic-feature module
- Project will contain the following components:
    - `Activity` for landing page (empty / blank page which redirects to search results page after launch)
    - `Activity` the search results page
    - `ViewModel` with function to fetch search results data from Repository
    - `Repository` with function to fetch search results data from Service or Database.
    - `Service` and `Database`

## Tech Stack
- Android `multi-module`
- `MVVM`
- `Hilt` for dependency injection
- `Room` for database
- `Retrofit` for networking
- `Gson` for json parsing
- `View binding` and `Data binding` for UI layer.
- `Coroutines` for async tasks.

## What we need your help with
- Fix any errors in the `Retrofit` implementation
- Fix any errors in the `Room` database implementation
- Fix any errors in the `Hilt` and `Dagger` dependency injection implementations
- Implement the function `fetchSearchResults` in the `Repository`:
    - if the results are available in the `Database`, then we'll need to return it
    - else we'll need to fetch the results from the `Service`, store the results in the `Database` and then return it
- Implement the function `fetchSearchResults` in  the`ViewModel`
    - we'll need to fetch the results from `Repository`
    - publish the results to the `Activity` via `LiveData`
- Implement the RecyclerView and RecyclerView Adapter using `View binding` and `Data binding`
- Style the `row_search_item.xml` to match the Figma design.
- Add unit tests for the `fetchSearchResults` function in the `ViewModel`.

## Design
Figma: https://www.figma.com/file/mEWTudJmPrEJWCUtl4nWH1/Android-challenge?node-id=1%3A651

<img width="418" alt="Screenshot 2021-10-04 at 1 24 10 AM" src="https://user-images.githubusercontent.com/7981907/135764791-3dc209b1-5da9-4bde-9371-90cc289d5349.png">

## JSON
https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/listings.json?print=pretty

```
[ {
  "address" : {
    "district" : "D13",
    "street_name" : "12 Meyappa Chettiar Rd"
  },
  "attributes" : {
    "area_size" : 2561,
    "bathrooms" : 2,
    "bedrooms" : 3,
    "price" : 2561
  },
  "category" : "Condo",
  "completed_at" : "2020",
  "id" : 0,
  "photo" : "https://picsum.photos/id/10/450/300",
  "project_name" : "Parkview Apartments",
  "tenure" : 99
}, {
  "address" : {
    "district" : "D19",
    "street_name" : "35 Hougang Ave 7"
  },
  "attributes" : {
    "area_size" : 1012,
    "bathrooms" : 3,
    "bedrooms" : 3,
    "price" : 4000
  },
  "category" : "Condo",
  "completed_at" : "1999",
  "id" : 1,
  "photo" : "https://picsum.photos/id/11/450/300",
  "project_name" : "Evergreen Park",
  "tenure" : 99
}, {
  "address" : {
    "district" : "D2",
    "street_name" : "3 Wallich St"
  },
  "attributes" : {
    "area_size" : 915,
    "bathrooms" : 2,
    "bedrooms" : 2,
    "price" : 3300
  },
  "category" : "Apartment",
  "completed_at" : "2022",
  "id" : 2,
  "photo" : "https://picsum.photos/id/12/450/300",
  "project_name" : "Wallich",
  "tenure" : 99
} ]
``` 
## Getting Started
To access the project for this assignment please go to https://github.com/team99/99-android-s-exercise/tree/master/v2

### Few things to keep in mind:
- It'll be good to commit your work frequently so that we can follow your progress and see how you worked through this problem.

### Instructions
1. Create your own fork of this repository to get started.
2. Remember to use the branch corresponding to the part of the exercise you're working on.
3. Once you've finished the challenge, grant shawn@shawnbaek.com access to the fork as admin and send us an APK file that can be installed on devices.
4. Add in any additional instructions we might need to setup the codebase on our local machines.
