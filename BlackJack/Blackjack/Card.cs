using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Blackjack
{
    public class Card : IComparable
    {
        private class SortBySuit : IComparer
        {
            int IComparer.Compare(object a, object b)
            {
                Card c1 = (Card)a;
                Card c2 = (Card)b;
                if (c1.Suit > c2.Suit)
                {
                    return 1;
                }
                else if (c1.Suit < c2.Suit)
                {
                    return -1;
                }
                return 0;
            }
        }

        private class SortByValue : IComparer
        {
            int IComparer.Compare(object a, object b)
            {
                Card c1 = (Card)a;
                Card c2 = (Card)b;
                if (c1.Value > c2.Value)
                {
                    return 1;
                }
                else if (c1.Value < c2.Value)
                {
                    return -1;
                }
                return 0;
            }
        }

        public int Value { get; set; }
        public Suit Suit { get; set; }
        public String Name { get; set; }
        public bool Visibility { get; set; }

        /// <summary>
        /// Card constructor
        /// </summary>
        /// <param name="value">The point value of the card</param>
        /// <param name="suit">The suit of the card</param>
        /// <param name="name">The name of the card</param>
        /// <param name="visibility">If the card is face up or face down</param>
        public Card(int value, Suit suit, String name, bool visibility)
        {
            Value = value;
            Suit = suit;
            Name = name;
            Visibility = visibility;
        }

        /// <summary>
        /// Set this card to be face down
        /// </summary>
        public void Hide()
        {
            Visibility = false;
        }

        /// <summary>
        /// Set this card to be face up
        /// </summary>
        public void Show()
        {
            Visibility = true;
        }

        public override bool Equals(Object obj)
        {
            bool areEqual = false;

            //Check for null and compare run-time types.
            if ((obj == null) || !this.GetType().Equals(obj.GetType()))
            {
                areEqual = false;
            }
            else
            {
                Card c = (Card)obj;
                if (this.Value == c.Value && this.Name.Equals(c.Name) && this.Suit.Equals(c.Suit))
                {
                    areEqual = true;
                }
            }
            return areEqual;
        }

        public override string ToString()
        {
            if (Visibility == false)
            {
                return "Hidden Card";
            }
            return Name + " of " + Suit.ToString();
        }

        /// <summary>
        /// Default sorting by value
        /// </summary>
        /// <param name="obj">Another card to compare this card's value with</param>
        /// <returns>1 if this card's value is more, -1 if this card's value is less, and 0 if they are the same</returns>
        int IComparable.CompareTo(object obj)
        {
            Card c = (Card)obj;
            if (this.Value > c.Value)
            {
                return 1;
            }
            else if (this.Value < c.Value)
            {
                return -1;
            }
            return 0;
        }

        /// <summary>
        /// Sort a collection of cards by the suit
        /// </summary>
        /// <returns>An ICompare instance that will compare the suit of two cards for sorting</returns>
        public static IComparer SortOnSuit()
        {
            return (IComparer)new SortBySuit();
        }

        /// <summary>
        /// Sort a collection of cards by the value
        /// </summary>
        /// <returns>An ICompare instance that will compare the value of two cards for sorting</returns>
        public static IComparer SortOnValue()
        {
            return (IComparer)new SortByValue();
        }
    }
}
