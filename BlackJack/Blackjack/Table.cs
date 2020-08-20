using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Blackjack
{
    /// <summary>
    /// Class Table is responsible for creating playable table instance to play BlackJack
    /// </summary>
    public class Table
    {
        private int pot = 0;
        private int bet = 0;
        public Player Player;
        public Dealer Dealer;

        public Table()
        {
            int stash = 500;
            Player = new Player("Steve", stash);
            Dealer = new Dealer(stash*5);
           
            // Create a player and  adealer object.  Give the dealer 5x the amount of money of the player to start
        }

        /// <summary>
        /// Play Blackjack until the player quits or one of the players runs out of money
        /// </summary>
        public void Play()
        {
            bool playAgain = true;
            int hit = 0;

            do
            {
                getBets();
                // Deal first two card to both players
                Player.ReceiveCard(Dealer.Deal(), true);
                Dealer.ReceiveCard(Dealer.Deal(), false);
                Player.ReceiveCard(Dealer.Deal(), true);
                Dealer.ReceiveCard(Dealer.Deal(), true);

                Console.WriteLine(Player);
                Console.WriteLine(Dealer);

                if (Player.ScoreHand() == 21)
                {
                    Console.WriteLine("Player Blackjack!\n");
                }
                else if (Dealer.ScoreHand() == 21)
                {
                    Console.WriteLine("Dealer Blackjack!\n");
                }
                else // Keep playing
                {
                    do
                    {
                        Console.Clear();
                        Console.WriteLine(Player);
                        Console.WriteLine(Dealer);
                        Console.Write("1. Hit\n2. Check\n\nEnter your selection: ");
                        // Should wrap in a try/catch
                        hit = Convert.ToInt32(Console.ReadLine());
                        if (hit == 1)
                        {
                            Player.ReceiveCard(Dealer.Deal(), true);
                        }
                        else if (hit == 2)
                        {
                            break;
                        }
                        else
                        {
                            Console.WriteLine("Invalid selection, please try again.");
                        }
                    } while (Player.ScoreHand() < 21);

                    // Dealer's turn now
                    Dealer.ShowAllCards();
                    Console.Clear();

                    if (Player.ScoreHand() > 21)
                    {
                        Console.WriteLine("Player Busts.");
                    }
                    else // Player didn't bust, dealer needs to play
                    {
                        while (Dealer.ScoreHand() < 17)
                        {
                            Console.Clear();
                            Dealer.ReceiveCard(Dealer.Deal(), true);
                            Console.WriteLine(Player);
                            Console.WriteLine(Dealer);
                            Pause();
                        }
                        if (Dealer.ScoreHand() > 21)
                        {
                            Console.WriteLine("Dealer Busts");
                        }
                    }
                }
                
                Console.Clear();
                ScoreGame();
                Console.WriteLine(Player);
                Console.WriteLine(Dealer);
                
                Player.ClearHand();
                Dealer.ClearHand();
                Dealer.Deck = new Deck();

                if (Player.Stash == 0)
                {
                    Console.WriteLine("PLEASE come again since you lost it all.");
                    break;
                }
                else if (Dealer.Stash == 0)
                {
                    Console.WriteLine("Congratulations! You broke the bank!");
                    break;
                }
                else
                {
                    Console.Write("1. Play again\n2. Quit\n\nEnter your selection: ");
                    // reusing hit for simplicity.  Should wrap in try/catch
                    try
                    {
                        hit = Convert.ToInt32(Console.ReadLine());
                    }
                    catch (Exception ex)
                    {
                        hit = 1;
                    }
                    if (hit == 2)
                    {
                        playAgain = false;
                    }
                }
            } while (playAgain);
            Console.WriteLine("Thank you for playing Blackjack! You finished with ${0}", Player.Stash);
        }

        /// <summary>
        /// Score the cards in the player's hand according to the rules of Blackjack
        /// </summary>
        private void ScoreGame()
        {
            if (Player.ScoreHand() > 21 || (Dealer.ScoreHand() > Player.ScoreHand() && Dealer.ScoreHand() <= 21))
            {
                Console.WriteLine("Dealer wins!");
                Dealer.Stash += pot;
            }
            else if (Dealer.ScoreHand() > 21 || (Player.ScoreHand() > Dealer.ScoreHand() && Player.ScoreHand() <= 21))
            {
                Console.WriteLine("Player wins!");
                Player.Stash += pot;
            }
            else // tie
            {
                Console.WriteLine("Push");
                if (pot == bet * 2)
                {
                    Player.Stash += bet;
                    Dealer.Stash += bet;
                }
                else // Dealer was all-in
                {
                    Player.Stash += bet;
                    Dealer.Stash = (pot - bet);
                }
            }
            pot = 0;
        }

        /// <summary>
        /// Get the user's bet and match or go all in from the dealer, then update the pot of money on the table
        /// </summary>
        private void getBets()
        {
            do
            {
                Console.Clear();
                Console.Write("Place your bet (up to ${0}): ", Player.Stash);
                try
                {
                    bet = Convert.ToInt32(Console.ReadLine());
                }
                catch(Exception ex)
                {
                    Console.WriteLine("That's not a number, betting 0");
                    bet = 0; // Invalid input, check
                }
            } while (bet > Player.Stash || bet < 0);

            pot = bet;
            Player.Stash = Player.Stash - bet;
            if (Dealer.Stash >= bet)
            {
                pot += bet;
                Dealer.Stash = Dealer.Stash - bet;
            }
            else
            {
                Console.WriteLine("Dealer can't match bet, going all in!");
                pot += Dealer.Stash;
                Dealer.Stash = 0;
            }
        }

        /// <summary>
        /// Pause a step in the game for 2 seconds for user effect
        /// </summary>
        private void Pause()
        {
            Thread.Sleep(2000);
        }
    }
}
