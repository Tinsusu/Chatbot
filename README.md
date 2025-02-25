# Chatbot Application (Java)
This chatbot application was built before the rise of large language models (LLMs). 
It operates using a simple keyword detection method based on a two-dimensional array. 
The chatbot searches for keywords in user input and provides predefined responses. 
If no keywords are detected, it selects a response from a default set.

## How it works
- The chatbot utilizes a **2D array**, where every two rows represent a set of keywords and their corresponding responses.
- The first row of each pair contains **keywords**, and the second row contains **responses** related to those keywords.
- The last row of the array consists of **default responses** in case no keywords are found in the user input.
- The program processes the user's input by converting it to **lowercase** and appending a space at the end to ensure accurate word matching.
- The chatbot **prioritizes** keywords found earlier in the array.
- When a keyword is detected, a random response is selected from the corresponding response row.
- If a response contains **special placeholders** like `+key+` or `+input+`, the chatbot replaces them dynamically with the detected keyword or the user’s input.

 ## Array Srtructure
  | Row 0 (Keys)     | hello | hi | hey |
| Row 1 (Responses)| Hello there! | Hi! How can I help? | Hey, what's up? |
| Row 2 (Keys)     | sad | bad | unhappy |
| Row 3 (Responses)| Why do you feel +key+? | I'm sorry to hear that. | What's making you +key+? |
| ...             | ...  | ... | ... |
| Last Row (Default Responses) | I'm not sure I understand. | Could you elaborate? | Tell me more! |


- **Flexible Keyword & Response Addition**: Users can modify the chatbot’s responses by updating the array without errors.
- **Priority-Based Matching**: Keywords in **earlier rows** take priority.
- **Full-Word Matching**: Ensures partial word matches do not trigger incorrect responses.
- **Dynamic Response Customization**: Uses placeholders like `+key+` and `+input+` for more natural interactions.
  
