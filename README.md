# BingoGame
 Bingo Game Using Multi-Linked List For Data Structures Course

1) Before starting the project description, if you want to learn how the numbers on the bingo cards and the numbers to be drawn are manually adjusted, please check the Application Details section.
2) Also, if you encounter an error when you run the application via “ZahidEsadBaltaciMainFrame”, please check the Notes section.

# INTRODUCTION
In this project, a bingo game was developed using Java Swing. The bingo game is played between two players and each player has a tombola card consisting of 15 numbers. Each card has 3 rows, and the 5 boxes in each row have numbers arranged horizontally. The remaining 4 boxes are blocked randomly. The aim of the project is to simulate this traditional bingo game. Multi Linked List was used to simulate this game.
The basic flow of the game is as follows: At the beginning, each player is given a random card. Next, drawing balls from a bag is simulated and the number of each drawn ball is shown on the screen. Circles with these numbers are automatically marked on users' cards. Once a player has marked all their circles, "Bingo!" appears on the game screen. Thus, the game ends and the winner is determined.


# CODE DESIGN
## The main purpose of object “ZahidEsadBaltaciNode”:
This class provides a multiple node structure for use in bingo game. There are three nodes: next, previous, and down.
## The main purpose of object “ZahidEsadBaltaciBingoLinkedList”:
This class provides a list data structure using the doubly linked list and multi linked list structure. In general, this structure offers the following functions:
1) Special Methods for Multi Linked List: Special methods such as “addByIndex(), getWithDownNode() and removeWithDownNode()” perform the operations of adding, accessing, and removing the elements of the list in accordance with the purpose of the project (using a multi-linked list).
2) Adding and Removing Elements in an Ordinary Way: Adding to the beginning and end of the list and removing a specific element from the list can be done. Methods such as “addToFirst(), addToEnd(), remove()” provide this.
3) Element Check: It can be checked whether the list contains a certain element. The contains() method performs this function.
4) Filtering and Removal: The removeIf() method can be used to remove elements that meet a certain condition from the list. This method removes elements that meet the specified condition from the list.
5) Cleaning and Size: Clearing the list content and getting the size of the list can be done. The clear() and size() methods perform these functions.
6) Iteration: Iterator interface is used to loop over the list. This allows accessing the elements of the list sequentially (I added for using for each loop).
-This class is designed to meet specific requirements for the Bingo game as well as a general linked list functionality. Below you can visually see the logic of “ZahidEsadBaltaciBingoLinkedList” class designed for the Bingo game:
![image](https://github.com/zahidesad/BingoGame/assets/116666407/0efb9d89-b77a-4e8e-bb27-73a70f864fb2)
## The main purpose of object “ZahidEsadBaltaciBingoCardNumber”:
-This class is used to generate Bingo card numbers. Bingo card consists of 3 rows and 5 columns (without blocked places), with each row containing numbers from a specific range of numbers. This class follows certain rules when generating random Bingo card numbers.
-The “cardNumberGenerator()” method uses the “randomNumberGenerator()” method to generate random numbers and sorts these numbers in a certain order. In bingo cards, each column must contain numbers from a certain range of numbers. So, at each step, it checks whether the numbers are in a certain range and places the numbers in a sequential manner, while deciding in which row and column to place the next random number.

### How to work cardNumberGenerator() method ?
1) Random numbers are generated using the "randomNumberGenerator()" method and added to a BingoLinkedList (multi linked list) named unsortedList. This list contains random numbers, not yet sorted.
2) An empty BingoLinkedList named "sortedList" is created. This list will contain Bingo card numbers sorted at the end.
3) A loop is started and continues until the size of sortedList is 15 (there are 15 numbers on a Bingo card)
4) In each iteration, a number is taken from unsortedList. This is done using the index variable, which allows the next number to be retrieved.
5) The range of the received number is determined. For example, if it is between 10 and 19, this number will appear in column 1. This information is obtained by dividing the number by 10.
6) If the "col" variable is 0, this number is added directly to the first column of the Bingo card and the col is incremented. Then the next number is taken.
7) If the variable "col" is not 0, the number is compared with other numbers in the sortedList. The comparison is made based on the range of the number. If the number being compared has a larger range than the next number, that number is added before it.
8) If the number cannot be placed in a suitable position, i.e. does not match any of the numbers with a smaller range, then the number is added to the end of the list.
9) After each number is added, the "col" variable is checked. If "col" is equal to 5, this means that one column is completed and should move on to the next column. In this case, col is reset, index is reset, and the next line is moved.
10) Finally, sortedList is returned, which is the sorted Bingo card. (All these transactions were carried out in accordance with the linked list logic shown in the figure above. There is no violation.)
This algorithm takes randomly generated numbers and places them sequentially on the Bingo card in a specific order. This method ensures that each column contains a certain range of numbers, which ensures that the Bingo card is balanced.

### How to work randomNumberGenerator() method?
Creating Lists
-allNumbers: A list is created to hold all possible Bingo numbers from 1 to 90.
-cardNumbers: An empty list is created to store the random numbers to be generated.
Creating Three Rows:
The method goes into a loop representing three rows on a Bingo card.
For each Row:
-All numbers from 1 to 90 are added to the “allNumbers” list.
-5 numbers are selected:
-A random index is created.
-The number in this index is taken as “selectedNumber”.
- If “selectedNumber” is already in the cardNumbers list, a new random number is chosen so that it cannot be selected again.
-“selectedNumber” is added to the list.
-With “selectedNumber”, other numbers in the same decimal range are removed from the allNumbers list to avoid duplication.
-The allNumbers list is cleared for the next line.

Arrangement of Numbers:
A call is made to another method called rearrangeNumbers (code details will be given below). This method rearranges the cardNumbers list.
-Method returns the rearranged list.

### What is the logic of method rearrangeNumbers() used in method randomNumberGenerator() and how does it work? 
The main purpose of this method is to assign these numbers to the end of BingoLinkedList if there are 3 numbers in the same range. For example, let's assume that there are three randomly generated numbers in the same range, such as 22-25-27. These numbers are placed at the end of the list. I can explain why as follows.

-Let's create an example scenario. In this scenario, let's say the randomNumberGenerator() method gives us 15 random numbers, with a maximum of 3 numbers in the same range.
1) {83-70-65-82-12-52-43-48-6-4-15-28-38-44-85} If I add these numbers to the linkedList in accordance with the logic of the cardNumberGenerator() method, it looks like this: It will happen.
First step: {   83}
Second step: {  70-83}
Third step: {65-70-83}
Fourth step:{12-65-70-83}
Fifth step: {12-52-65-70-83}
Sixth step: {12-52-65-70-83
                         82}
Eighth step: {12-52-65-70-83
                     6-43-82}
Eleventh step: {12-52-65-70-83
                 6-15-28-43-82
                            4}
Last step: {12-52-65-70-83
            6-15-28-43-82
            4-38-44-48-85}
As seen in the example scenario, groups of 3 (such as 43-44-48) may cause such a violation. Therefore, by using the "rearrangeNumbers()" method, groups of 3 are placed at the top of the list and this violation is prevented.
## The main purpose of object “ZahidEsadBaltaciGame”:
-This class represents a Bingo game and manages different aspects of the game. In general, the purpose of this class is to:
1) Player Management: Represents the players in the game. The number of players and their cards are managed through this class.
2) Game Status: Tracks the current status of the game (checkNumbers() method). Information such as which player is in which round (bingo count), which numbers are drawn, and which player wins (updateAndCheckBingo() method) is stored and updated through this class.

### How to work checkNumbers() method?
This method checks the numbers in one round of a Bingo game. It performs the function in these steps:
1) Parameters:
-playerCount: Number of players.
-numberLabel: A JLabel object that represents a number.
-bingoLabels: A BingoLinkedList<JLabel> object that represents players' Bingos.
-jFrame: An object representing the Swing JFrame component.
2) Converts the text on numberLabel to a number. This number represents the number drawn during the game.
3) Starts the loop for each player:
-Retrieves a player from the "players BingoLinkedList".
-Retrieves a JLabel from the player’s “cardNumbers (BingoLinkedList)”.
4) Checks the numbers on each player's card:
-If the player card is completed (isOver() method returns true), game is over.
5) Checks each cell on the card:
-If the cell is not empty (!text.isEmpty()), it converts the text inside it to a number.
    -If the number drawn matches the number on the card:
    -Marks the state of the cell as setIsFound(true). SetIsFound
     method comes from the customJLabel class.
    -Changes the color of the cell.
    -Checks the player's status (checkStatus() method will be explained).
    -A message on bingoLabel according to the player's status images.
    -If the player won the game (isOver() returns true):
        -Shows a dialog box indicating the winning player.
        -Closes the game window and turns off its visibility.
        -Ends the process and returns.

This method compares the numbers on each player's card with the number drawn and processes accordingly. If a player provides a Bingo status, they update the status and take the necessary actions. If the player wins the game, he declares the winner and ends the game.

### How to work updateAndCheckBingo () method?
This method contains the logic and algorithm required for a Bingo game. Its function follows these steps:
1) The isRandom parameter determines whether the method returns a random number or a predetermined sequence of numbers.
-If isRandom is true (If the cards and numbers drawn in the game are desired to come randomly, this parameter will be true). It selects the next number randomly and displays this number on the numberLabel.
-If isRandom is false and the index does not exceed the size of the randomPermutation array, it takes the next number in the randomPermutation array, displays this number on the numberLabel, and increments the index value by one. This allows numbers to be displayed in a predetermined order.
-If isRandom is false and index exceeds the size of the randomPermutation array, resets the index value. This means that all the numbers in the series have been shown and now it is necessary to start again.
2) By calling the checkNumbers method, it performs the process of checking this number on the game cards. This method checks whether a particular number has appeared on the playing cards and, if so, updates the corresponding playing card.
3) Finally, it uses other parameters like playerCount, numberLabel, statusBingoLabel and jFrame to check the status of the game (for example, whether a person has won the game or not).

3) Card Production: Bingo cards are produced for players. These cards contain specific numbers, and these numbers can be generated randomly or manually. (setCardNumbersRandomly() and setCardNumbersManually methods)
4) Number Draw and Check: During the game, numbers are generated randomly with the generatePermutation() method. Then the numbers are drawn, and it is checked whether these numbers are on the player cards. The progress of the game is directed by this class as numbers are drawn and cards are checked. (checkNumbers() method)
### How to work generatePermutation () method?
This method creates a permutation of numbers 1 through n in an array. Permutation orders these numbers differently from each other.

The logic of the algorithm follows these steps:
1) First, an array of length n is created and numbers from 1 to n are assigned to this array sequentially.
2) Then, the elements of the array are randomly swapped using the Fisher-Yates shuffle algorithm. This means that each element in the array is randomly replaced by another element.
-For this step, it is replaced with another random element, starting from the last element of the array. This process continues until the last element of the array.
-Replacing randomly selected elements ensures that each element is placed in a different position in the array. This creates a permutation of the sequence.
-Finally, the generated permutation is returned as an array.
This algorithm produces all permutations of an n-element array with equal probability. Therefore, each permutation has the same probability of being selected. This randomly swaps the elements of the array, providing the possibility that each element will end up in a different position.
5) End of Game Control: If a player makes Bingo or the game needs to end, this situation is detected, and necessary actions such as updating the current status are taken. (checkNumbers() method)
-As a result, this class performs the functions of starting, managing and ending the Bingo game. It controls the basic logic and flow of the game and ensures that the game progresses smoothly.

## The main purpose of object “ZahidEsadBaltaciPlayer”:
- This class represents a player in the Bingo game and keeps track of the card the player has and their Bingo status. In general, the purpose of this class is to:
1) Player Card Management: Represents the player's Bingo card. The card is stored as CustomJLabel elements within a custom Bingo Linked List structure. Each item represents a number on the card.
2) Bingo Status Tracking: Tracks the player's Bingo status. It checks whether the numbers on the card are marked correctly and determines how many Bingos the player has made. (checkStatus() method)
3) Player Status Update: The player's Bingo status is updated based on the numbers marked on the card. If the numbers on the card are marked in a certain pattern, the player is detected to have made Bingo. (checkStatus() method)
4) Determining Game End: It determines that the game is over when the player plays Bingo. This causes the game to end. (isOver() method)
- This class manages the player's card while also updating the player's Bingo status and affecting the progress of the game. Tracks how many times the player has done Bingo. In this way, it tracks the player's success and progress in the game.
The main purpose of object “ZahidEsadBaltaciMainFrame”:
- This class is the frame that must be run for the game to start. In addition, the number of players and whether the bingo cards and numbers to be drawn will be set as random or manual are determined here.
The main purpose of object “ZahidEsadBaltaciGameFrame”:
- The purpose of this class is to visualize the game using the functions of all the classes written above. It is the GUI part of the project.

# APPLICATION DETAILS
## How to manually set card numbers and numbers to draw
1) Please go to the "ZahidEsadBaltaciGame" class in the "ZahidEsadBaltaciBingoGameClasses" java package.
2) Change the “randomPermutation []” array below to adjust the numbers to be drawn.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/85583cbf-b143-415a-9d59-49b71cb065ae)
3) To change bingo cards, please change the “manuelTombalaCardGeneretor()” method
![image](https://github.com/zahidesad/BingoGame/assets/116666407/3b35dab8-0602-4e0c-adf5-c2b36097592d)
4) To see these changes on the screen, when you run the application via "ZahidEsadBaltaciMainFrame", do not tick the "Generate Bingo Card Randomly" checkbox, which you can see in the photo below.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/4442fc83-e557-43c2-82b7-8933dcc8ca4d)
## Sample Scenario
- In the scenario described visually below, not all stages of the game are given. If you want to watch the scenario consisting of all stages of the game, you can click on the drive link below.
Video Link: 
https://drive.google.com/file/d/1lB-sfblhSJzgc--VJEN8UuYU7LqduCBk/view?usp=sharing
1) First, run the application via "ZahidEsadBaltaciMainFrame" in the "ZahidEsadBaltacıBingoGameGUI" java package.
2) Select the number of players you want to play with (1-4 players allowed.) and whether you want to play with random cards. After this click “Click for playing” button. From this stage the game starts.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/58c553aa-f599-4729-8bc6-6b44922f9093)
3) Since we ticked the random checkbox at the beginning, everything in the game comes as random. To draw a number, the "Click for new number" button must be pressed.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/974b1fef-3489-4465-8198-94c18c25c8e8)
4) When each button is pressed, numbers between 1-90 appear randomly and without repetition. If the number shown is on any of the cards, that number is marked on the card.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/4091e61f-cbda-48d1-8f89-6d6b9670b3b8)
5) An image from later in the game
![image](https://github.com/zahidesad/BingoGame/assets/116666407/3047c35d-d18c-463d-8e27-5584ca4cf449)
6) If all the numbers on any row of any player are marked, it is the first bingo. When this event occurs, the bottom right panel is updated.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/c33977eb-bb8f-466b-b066-16553dc4ad93)
7) If the same event happens a second time, this event is called second bingo, and the bottom right panel is updated.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/6107d94b-cc47-4c15-873b-4470fd5818c8)
8) If all the player's numbers are marked, it is called bingo, and the game is over.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/f6437f6c-b938-49bc-a872-d78c4d8749ae)
# GUI PART
Two JFrames were used in the project. The first of these is "ZahidEsadBaltaciMainFrame", and another is “ZahidEsadBaltaciGameFrame”. When designing these frames, "CustomJLabel" and "CustomJButton" classes were written specifically to use round labels and buttons with rounded corners. Additionally, some images were used in the GUI design.
# CONCULUSION
In the beginning, one of the biggest challenges of the project was to correctly design and implement the multi-linked list structure. A multi-linked list is a data structure that often requires complex connections and operations. To overcome this challenge, I first had to thoroughly understand basic linked list concepts and then do in-depth research on how to create multiple links. During this process, I had the opportunity to learn more about algorithms and data structures, which was a very valuable learning experience for me.

However, in the later stages of the project, I encountered challenges with UI design and user experience. Various trials and feedback were required to enable users to easily play the game and provide a user-friendly interface. During this process, I experienced a significant learning and development process to understand users' expectations and provide them with an appropriate experience.

One of the most important things I learned in the project was my ability to implement more complex data structures and algorithms. Understanding and implementing more advanced data structures such as multi linked list has greatly contributed to improving my software skills.
# NOTES
If you encounter an error when you run the application via “ZahidEsadBaltaciMainFrame”, follow the steps below.
1) Please right click on the project name and select properties.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/c5795077-d358-4c28-bba6-b39cf14165bb)
2) Please go to the “Source” menu and set the "Source Binary Format" section to 17.
![image](https://github.com/zahidesad/BingoGame/assets/116666407/c71cd994-f6d4-4ac0-81b9-e06e99e9f60d)















