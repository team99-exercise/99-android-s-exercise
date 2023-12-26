# Team 99 - Android Exercise
​
This is a fun exercise/challenge to help us assess the skill of candidates interested in joining the engineering team at 99.co. If you would like to attempt it, create your own fork and starting coding away!
​
Duration: ~4 hours
​
## Introduction
You are going to complete 2 pages from scratch.
​
### `Search Result Page`: Displaying listings
Every time users open this page, the following steps will be executed:
1. Return listing results from local `database` if not empty
2. Else fetch results from [Search Result Endpoint](https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/listings.json)
3. Cache results in local `database`
4. Return results
​
### `Listing Detail Page`: 
User will be pushed to this page after clicking listing in `Search Result Page`
​
## Requirements
You can implement the assignment using any libraries and architecture you want. However, we have some requirements for you to follow.
​
1. Follow the design in Figma as much as possible.
2. Implement assignment in Kotlin
3. (Optional for intern) Use coroutines for async tasks
4. (Optional for intern) Use dependency injection framework
5. (Optional) Unit Testing.
​
**Tips for intern:**
1. Please submit a runnable project 
2. Do as much as you can, if you can't implement some features, please leave a comment in the code to explain what you want to do.
​
## Design
Figma: https://www.figma.com/file/mEWTudJmPrEJWCUtl4nWH1/Android-challenge?node-id=1%3A651
​
<img width="418" alt="Screenshot 2021-10-04 at 1 24 10 AM" src="https://user-images.githubusercontent.com/7981907/135764791-3dc209b1-5da9-4bde-9371-90cc289d5349.png">
​
## Endpoints
- [Search Result](https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/listings.json)
- [Listing Detail](https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/details/0.json)
​
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
1. Create your own fork of this repository to get started.
2. Create the android project in the root of the repository.
3. commit your work frequently so that we can follow your progress and see how you worked through this problem.
4. Once you've finished the challenge, grant shawn@shawnbaek.com myeiklin@gmail.com wangberlin2000@gmail.com funclosure@gmail.com and akqeelnawaz@windowslive.com access to the fork as admin and send us an APK file that can be installed on devices.
5. Add in any additional instructions we might need to setup the codebase on our local machines.