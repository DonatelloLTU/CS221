using Microsoft.VisualBasic;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;

namespace Blackjack
{
    public class Deck
    {
        public List<Card> Cards { get; set; } = new List<Card>();

        /// <summary>
        /// Build a shuffled deck of 52 cards by looping over the suits and the values
        /// </summary>
        public Deck()
        {
            // Build list of cards
            foreach (Suit suit in Enum.GetValues(typeof(Suit)))
            {
                for (int i = 2; i < 15; i++)
                {
                    if (i < 11)
                    {
                        Cards.Add(new Card(i, suit, Convert.ToString(i), true));
                    }
                    else if (i == 11)
                    {
                        Cards.Add(new Card(10, suit, "Jack", true));
                    }
                    else if (i == 12)
                    {
                        Cards.Add(new Card(10, suit, "Queen", true));
                    }
                    else if (i == 13)
                    {
                        Cards.Add(new Card(10, suit, "King", true));
                    }
                    else
                    {
                        Cards.Add(new Card(11, suit, "Ace", true));
                    }
                }
            }
            Shuffle();
        }

        /// <summary>
        /// Using Linq and a random number generator to shuffle
        /// </summary>
        public void Shuffle()
        {
            Random rnd = new Random();
            Cards = Cards.OrderBy(x => rnd.Next()).ToList();
        }

        /// <summary>
        /// Play 52 pickup!
        /// </summary>
        /// <returns></returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            foreach (Card card in Cards)
            {
                sb.Append(card + "\n");
            }
            return sb.ToString();
        }
    }
}
