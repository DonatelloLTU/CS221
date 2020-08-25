using Microsoft.VisualStudio.TestTools.UnitTesting;
using Blackjack;
using System;
using System.Collections.Generic;
using System.Text;

namespace Blackjack.Tests
{
    [TestClass()]
    public class PlayerTests
    {
        [TestMethod()]
        public void PlayerTest()
        {
            //Arange
            Player Hill_Billie = new Player("Hill Billie", 3000);
            Player Numbnuts = new Player();
            //Act
            //Assert
            Assert.IsTrue(Hill_Billie.Name.Equals("Hill Billie"));
            Assert.IsTrue(Hill_Billie.Stash == 3000);
        }


        [TestMethod()]
        public void ReceiveCardTest()
        {
            //Arange
            Player BigNutz = new Player();

            //Act
            BigNutz.ReceiveCard(new Card(6, Suit.Hearts, "6 of hearts", false), false);

            //Asert
            Assert.IsTrue(BigNutz.Hand.Count == 1);
        }

        [TestMethod()]
        public void ClearHandTest()
        {
            //Arange
            Player Stefan = new Player();
            //Act
            Stefan.ReceiveCard(new Card(6, Suit.Hearts, "6 of hearts", false), false);
            Stefan.ClearHand();

            //Assert
            Assert.IsTrue(Stefan.Hand.Count == 0);
        }

        [TestMethod()]
        public void ScoreHandTest()
        {
            Assert.Fail();
        }

        [TestMethod()]
        public void ShowAllCardsTest()
        {
            //Arange
            Player Jimmie = new Player();
            //Act
            Jimmie.ReceiveCard(new Card(6, Suit.Hearts, "6 of hearts", false), false);
            Jimmie.ReceiveCard(new Card(5, Suit.Hearts, "5 of hearts", false), false);
            Jimmie.ShowAllCards();
            //Assert
            Assert.IsTrue(Jimmie.Hand.Count == 2);
            ////Not finished

        }

        [TestMethod()]
        public void ToStringTest()
        {
            Assert.Fail();
        }


    }
}