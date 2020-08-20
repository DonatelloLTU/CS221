using Blackjack;
using NUnit.Framework;

namespace BlackjackTests
{
    public class CardTests
    {
        [SetUp]
        public void Setup()
        {
            
        }

        [Test]
        public void CardConstructorTest()
        {
            // Arrange
            Card card1 = new Card(11, Suit.Spades, "Ace", true);
            Card card2 = new Card(10, Suit.Hearts, "Jack", false);
            // Act

            // Assert
            Assert.IsTrue(card1.Visibility);
            Assert.IsFalse(card2.Visibility);
            Assert.AreEqual(card1.Value, 11);
            Assert.AreEqual(card2.Value, 10);
            Assert.AreEqual(card1.Suit, Suit.Spades);
            Assert.AreEqual(card2.Suit, Suit.Hearts);
            Assert.IsTrue(card1.Name.Equals("Ace"));
            Assert.IsTrue(card2.Name.Equals("Jack"));
        }

        [Test]
        public void CardEqualityTest()
        {
            // Arrange
            Card card1 = new Card(10, Suit.Hearts, "Jack", true);
            Card card2 = new Card(10, Suit.Hearts, "Jack", false); // Visibility shouldn't matter when testing equality
            Card card3 = new Card(11, Suit.Spades, "Ace", true);
            // Act
            
            // Assert
            Assert.IsFalse(card1.Equals(card3));
            Assert.IsTrue(card1.Equals(card2));
        }


        [Test]
        public void CardHideTest()
        {
            // Arrange
            Card card = new Card(10, Suit.Hearts, "Jack", true);
            // Act
            card.Hide();
            // Assert
            Assert.IsFalse(card.Visibility);
        }

        [Test]
        public void CardShowTest()
        {
            // Arrange
            Card card = new Card(10, Suit.Hearts, "Jack", false);
            // Act
            card.Show();
            // Assert
            Assert.IsTrue(card.Visibility);
        }
    }
}
