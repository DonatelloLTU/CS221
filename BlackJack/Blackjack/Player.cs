using System;
using System.Collections.Generic;
using System.Text;

namespace Blackjack
{
    /// <summary>
    /// Class player creates instance of player with specified name and stash.
    /// </summary>
    public class Player
    {
        // Field to hold the value of Stash property
        private int _stash;
        public List<Card> Hand { get; set; } = new List<Card>();
        public String Name { get; set; }
        public int Stash 
        {
            get 
            { 
                return _stash; 
            }
            set // Do validation on the field to ensure it is a positive number
            {
                if (value < 0)
                {
                    throw new InvalidOperationException("Cannot start the game without money.");
                }
                else
                {
                    _stash = value;
                }
            }
        }

        /// <summary>
        /// Default constructor setting the name to "Player" and the money to start the game at $500
        /// </summary>
        public Player()
        {
            Name = "Player";
            Stash = 500;
        }

        /// <summary>
        /// Overloaded constructor customizing the name and amount of money brought to the game
        /// </summary>
        /// <param name="name">The player's name</param>
        /// <param name="stash">The amount of money to start the game with</param>
        public Player(String name, int stash) 
        {
            Name = name;
            Stash = stash;
        }
        

        /// <summary>
        /// Get a card from the dealer and put it in the hand
        /// </summary>
        /// <param name="card">A card from the deck</param>
        /// <param name="visibility">If true, the card is face up, if false the card is face down</param>
        public void ReceiveCard(Card card, bool visibility)
        {

            if (visibility == true)
            {
                Hand.Add(card);
            }
            else
            {
                card.Hide();
                Hand.Add(card);
            }
            // Check if the visibility is true. If so, add it to the hand
            
            // If not, hide the card, then add it to the hand
            
        }

        /// <summary>
        /// Reset the hand to empty for the next round of play
        /// </summary>
        public void ClearHand()
        {
            Hand.Clear();
            // delete the entries from the Hand array list
        }

        /// <summary>
        /// Score the hand according to the rules of Blackjack
        /// </summary>
        /// <returns>An integer represenging the score of the cards in the player's hand</returns>
        public int ScoreHand()
        {
            int score = 0;
            // Check for Blackjack
            if (Hand.Count == 2)
            {
                foreach (Card card in Hand)
                {
                    score += card.Value;
                }
                if (score == 21)
                {
                    ShowAllCards(); // In case this is the dealer
                    return score;
                }
            }
            // Score hand normally if not Blackjack
            score = 0;
            foreach (Card card in Hand)
            {
                // Hide the dealer's first card score if it is face down
                if (card.Visibility == true)
                {
                    score += card.Value;
                }
            }

            // Check if Ace being 11 puts score over 21
            if (score > 21)
            {
                foreach (Card card in Hand)
                {
                    if (card.Value == 11 && card.Visibility == true)
                    {
                        // Make the Ace count as 1 point
                        score -= 10; 
                        // If this is a valid score, leave remaining Aces as 11 pointers
                        if (score <= 21)
                        {
                            break;
                        }
                    }
                }
            }
            return score;
        }

        /// <summary>
        /// Flip all cards face up
        /// </summary>
        public void ShowAllCards()
        {
            foreach (Card Card in Hand)
            {
                Card.Show();
            }
            // Loop through all cards and call the Show method
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();

            sb.Append(Name + " has $" + Stash + "\n");
            sb.Append("Current Score: " + ScoreHand() + "\n");
            foreach (Card card in Hand)
            {
                sb.Append(card + "\n");
            }
            return sb.ToString();
        }
    }
}