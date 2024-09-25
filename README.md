## Fetch Reward Take Home Test Android App
This is a simple single-activity app that fetches the data from the Fetch's AWS server, and displays that as categorical list on the screen. 

## Language, Libraries, and Architecture Used
**Kotlin -**
for the coding.

**Jetpack Compose -**
for the UI components. Particularly used LazyColumn for with stickyHeader for the categorical list. Even though the LazyColum is known to have some performance problem in debug build, I deliberately went with it instead of good 'ol XML based RecyclerView because I wanted to do this project in the context of modern Android development paradigm to practice more Compose. 

**Retrofit -**
for the REST service call to fetch the data.

**MVVM + Repository + UseCases -**
as architecture. 



## Requirements

Display this list of items to the user based on the following requirements:

1. Display all the items grouped by "listId"
2. Sort the results first by "listId" then by "name" when displaying.
3. Filter out any items where "name" is blank or null.
4. The final result should be displayed to the user in an easy-to-read list.

## How to run the app?

1. Clone the repository
2. Open it in the Android Studio
3. Build the project
4. Run the app in an emulator/real device
