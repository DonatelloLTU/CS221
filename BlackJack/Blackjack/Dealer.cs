using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Transactions;

namespace Blackjack
{
    /// <summary>
    /// 
    /// </summary>
    public class Dealer : Player
    {
        /// <summary>
        /// The deck of cards with which to play the game
        /// </summary>
        public Deck Deck { get; set; }
        /// <summary>
        /// Constructor setting the dealer's name to "Dealer" and the dealer's money to 5x the player's money
        /// </summary>
        /// <param name="stash">The amount of money the dealer has to play with</param>
        public Dealer(int stash) : base("Dealer", stash)
        {
            Deck = new Deck();

            // Set the name, stash of the dealer, and create a new instance of Deck
        }

        /// <summary>
        /// Deal a card from the deck
        /// </summary>
        /// <returns>A card from the deck, or null if empty</returns>
        public Card Deal()
        {

            Card NewCard = null;
            try
            {
                NewCard = Deck.Cards.ElementAt(Deck.Cards.Count() - 1);
                Deck.Cards.Remove(NewCard);  
            }
            catch (IndexOutOfRangeException )
            {
                
            }

            return NewCard;
        
            
        }
    }
}
