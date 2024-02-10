package cards;

public class UnoCard extends Card {

    private boolean reverse;
    private int drawAmount;
    private boolean wild;
    private boolean skip;

    public UnoCard(int cardNumber) {
        super(cardNumber); // Call the constructor of the parent 'Card' class
        createCard(); // Create the Uno card details
    }


    private void createCard() {

        // Constants for clarity
        int CARDS_PER_COLOR = 20; // Including '0' for all colors
        int START_SKIP = 20;
        int START_REVERSE = 28;
        int START_DRAW2 = 36;
        int START_WILD = 56;
        int START_DRAW4 = 108;

        // Card Colors
        String[] colors = {"r", "y", "g", "b", "w"}; // Including 'w' wild

        // Card Faces
        String[] numberedFaces = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] actionFaces = {"SK", "RV", "D2"};

        // 1. Numbered Cards (0-9 in each color)
        if (cardNumber <= CARDS_PER_COLOR) {
            color = colors[(cardNumber - 1) / CARDS_PER_COLOR];
            face = numberedFaces[(cardNumber - 1) % 10];
        }

        // 2. Action Cards (Skip, Reverse, Draw 2)
        else if (cardNumber <= START_DRAW2 - 1) {
            int colorIndex = (cardNumber - START_SKIP) / 6;
            int faceIndex = (cardNumber - START_SKIP) % 6;

            color = colors[colorIndex];
            face = actionFaces[faceIndex / 2]; // 0, 1, 2 -> 0, 1, 1

            // Set the action specific attributes
            if (face.equals("SK")) skip = true;
            else if (face.equals("RV")) reverse = true;
            else drawAmount = 2;
        }
        // 3. Wild Cards
        else if (cardNumber <= START_DRAW4 - 1) {
            color = "w"; // Wild
            face = "WD";
            wild = true;
        }

        // 4. Wild Draw 4 Cards
        else {
            color = "w";
            face = "D4";
            wild = true;
            drawAmount = 4;
        }
    }
}
