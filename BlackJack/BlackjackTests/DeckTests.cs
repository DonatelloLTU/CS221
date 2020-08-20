using Blackjack;
using NUnit.Framework;

namespace BlackjackTests
{
    public class DeckTests
    {
        [Test]
        public void DeckConstructorTest()
        {
            // Arrange
            Deck deck = new Deck();
            // Act

            // Assert
            Assert.AreEqual(deck.Cards.Count, 52);
        }

        [Test]
        public void DeckShuffleTest()
        {
            // Arrange
            Deck deck1 = new Deck();
            Deck deck2 = new Deck();

            // Act
            int element = 0;
            // Deep copy so both are identical
            foreach (Card card in deck1.Cards)
            {
                deck2.Cards[element] = card;
                element++;
            }
            // If this works, the two card collections will now be different
            deck1.Shuffle();

            // Assert
            Assert.AreNotEqual(deck1.Cards, deck2.Cards);
        }
    }
}
