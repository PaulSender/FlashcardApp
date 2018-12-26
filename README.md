## Flashcard_App

## Lab 4

### App Description
Application now has animaitons to draw user in as well as aid in the understanding of app functions. Animations were added to the "add" button, the "next" button, and when the "question" is clicked - the answer is reviled with a circular animation. 

### App Walk-though

<img src="https://media.giphy.com/media/SJGJFDgXROrNtGnZaN/giphy.gif" width=200><br>



## Required
- [x] User sees a transition animation when going from the main screen to the add card screen.
- [x] User sees a reveal animation when the flashcard is tapped and the answer is shown
- [x] User sees flashcards animating in / out when the 'next' button is tapped

## Optional
- [X] Extra styling is added!
- [ ] User sees a countdown timer for each question
- [ ] User sees a 'card flip' animation when the card is tapped
- [ ] User sees a celebration animation with confetti when they answer a question correctly

   ### Needs fixing
     X Deleting top of stack crashes App due to reference to a -1 index
     - Adding on the emulator doesn't update the Database
     - Animations needs a Lib to look smoother
   ### Future Features
      - Current card info (and other Info) at top of MainActivity
      - Button to create "new" stack (essentially deletes all the cards and brings you to the add screen) 
      - Stack state saving to allow for multiple seperate stacks of cards

## Lab 3

### App Description
Allows the user to save cards to a locally hosted database. The user can also cycle through cards in the stack and delete them. Addional functionality like editing database cards and adding multiple choice answers to the database will come in a later version. 

### App Walk-though

<img src="https://media.giphy.com/media/xUmO1qiCjRH7miXRXh/giphy.gif" width=200><br>


## Required
- [x] User can create a card and still see their created card when the app is relaunched.
- [x] User can create muliple cards and browse through all created cards

## Optional
- [x] User can delete a card and no longer see it in their deck anymore
- [ ] Flashcards are shown in random order instead of the order they were created in
- [ ] User can edit a card and see the edit saved when they browse through their deck of cards
- [ ] User can create flashcards with multiple answers and be able to browse through cards with multiple choice answers shown

## Lab 2

### App Description
A flash card application that allows you to edit existing card and add a new card that can also be edited. All functionality from previous version is present in this version. Style of application was updated to be more user friendly. 

### App Walk-though


<img src="https://media.giphy.com/media/65CdyMcPay562dELS5/giphy.gif" width=200><br>



## Required
- [x] User can click on a ‘+’ button that takes the user to new ‘Add Card Screen’
- [x] The 'Add Card Screen' has a cancel button to take the user back to the main screen
- [x] User can enter and submit a Question and Answer through the 'Add Card Screen'
- [x] User will see the card they just created on the main screen when they press the 'Save Button'
- [x] Push your progress to GitHub!

## Optional
- [x] User can edit a card
- [x] An error message is shown if the user doesn't enter both a Question and an Answer
- [x] A notification is shown if the card was created successfully
- [x] User can also enter multiple choice answers when creating a card
- [x] App is further styled and customized! 
   ### To be fixed
   - [ ] Options do not show up all at once when in edit.
   - [ ] Correct answer choice does not show up when in add.
   - [ ] Option 1 and 2 get switched when going into edit.

### App Description
A simple flashcard application that displays a questions and when clicked shows the answer

### App Walk-though

<img src="https://media.giphy.com/media/9xgaRrmNuFTSzjeXpw/giphy.gif" width=200><br>

## Required
- [x] Create New Project in Android Studio
- [x] Add a view for the front side of the flashcard to display the question
- [x] Add a view for the back side of the flashcard to display the answer
- [x] Build in logic to show the answer side when the card is tapped
- [x] Push code to GitHub
## Optional
- [x] toggle the flashcard between the question side and the answer side
- [x] Style the question and answer side of the card to better distinguish between the two sides
- [x] Add selectable multiple choice answers beneath the card
   - [x] Change the background color of the multiple choice answers when clicked to indicate whether the question waanswered correctly
- [x] Further customize and style the card
