package eu.veldsoft.vitosha.blackjack;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends Activity {
	private Game game = null;
	private Table table = null;

	private ImageView player1cards[] = new ImageView[10];
	private ImageView player2cards[] = new ImageView[10];

	private Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();

	private void updateViews() {
		table.updateAll(game.getDealer().getHand(), game.getPlayer().getHand(),
				(game.getDealer().areCardsFaceUp()) ? true : false);

		mapping.put(1, R.drawable.card01);
		mapping.put(2, R.drawable.card02);
		mapping.put(3, R.drawable.card03);
		mapping.put(4, R.drawable.card04);
		mapping.put(5, R.drawable.card05);
		mapping.put(6, R.drawable.card06);
		mapping.put(7, R.drawable.card07);
		mapping.put(8, R.drawable.card08);
		mapping.put(9, R.drawable.card09);
		mapping.put(10, R.drawable.card10);
		mapping.put(11, R.drawable.card11);
		mapping.put(12, R.drawable.card12);
		mapping.put(13, R.drawable.card13);
		mapping.put(14, R.drawable.card14);
		mapping.put(15, R.drawable.card15);
		mapping.put(16, R.drawable.card16);
		mapping.put(17, R.drawable.card17);
		mapping.put(18, R.drawable.card18);
		mapping.put(19, R.drawable.card19);
		mapping.put(20, R.drawable.card20);
		mapping.put(21, R.drawable.card21);
		mapping.put(22, R.drawable.card22);
		mapping.put(23, R.drawable.card23);
		mapping.put(24, R.drawable.card24);
		mapping.put(25, R.drawable.card25);
		mapping.put(26, R.drawable.card26);
		mapping.put(27, R.drawable.card27);
		mapping.put(28, R.drawable.card28);
		mapping.put(29, R.drawable.card29);
		mapping.put(30, R.drawable.card30);
		mapping.put(31, R.drawable.card31);
		mapping.put(32, R.drawable.card32);
		mapping.put(33, R.drawable.card33);
		mapping.put(34, R.drawable.card34);
		mapping.put(35, R.drawable.card35);
		mapping.put(36, R.drawable.card36);
		mapping.put(37, R.drawable.card37);
		mapping.put(38, R.drawable.card38);
		mapping.put(39, R.drawable.card39);
		mapping.put(40, R.drawable.card40);
		mapping.put(41, R.drawable.card41);
		mapping.put(42, R.drawable.card42);
		mapping.put(43, R.drawable.card43);
		mapping.put(44, R.drawable.card44);
		mapping.put(45, R.drawable.card45);
		mapping.put(46, R.drawable.card46);
		mapping.put(47, R.drawable.card47);
		mapping.put(48, R.drawable.card48);
		mapping.put(49, R.drawable.card49);
		mapping.put(50, R.drawable.card50);
		mapping.put(51, R.drawable.card51);
		mapping.put(52, R.drawable.card52);

		player1cards[0] = (ImageView) findViewById(R.id.player1card1);
		player1cards[1] = (ImageView) findViewById(R.id.player1card2);
		player1cards[2] = (ImageView) findViewById(R.id.player1card3);
		player1cards[3] = (ImageView) findViewById(R.id.player1card4);
		player1cards[4] = (ImageView) findViewById(R.id.player1card5);
		player1cards[5] = (ImageView) findViewById(R.id.player1card6);
		player1cards[6] = (ImageView) findViewById(R.id.player1card7);
		player1cards[7] = (ImageView) findViewById(R.id.player1card8);
		player1cards[8] = (ImageView) findViewById(R.id.player1card9);
		player1cards[9] = (ImageView) findViewById(R.id.player1card10);

		player2cards[0] = (ImageView) findViewById(R.id.player2card1);
		player2cards[1] = (ImageView) findViewById(R.id.player2card2);
		player2cards[2] = (ImageView) findViewById(R.id.player2card3);
		player2cards[3] = (ImageView) findViewById(R.id.player2card4);
		player2cards[4] = (ImageView) findViewById(R.id.player2card5);
		player2cards[5] = (ImageView) findViewById(R.id.player2card6);
		player2cards[6] = (ImageView) findViewById(R.id.player2card7);
		player2cards[7] = (ImageView) findViewById(R.id.player2card8);
		player2cards[8] = (ImageView) findViewById(R.id.player2card9);
		player2cards[9] = (ImageView) findViewById(R.id.player2card10);

		((TextView) findViewById(R.id.message_text)).setText(game.getDealer()
				.says());

		((TextView) findViewById(R.id.available_cards_text)).setText(""
				+ game.getDealer().cardsLeftInPack());
		((TextView) findViewById(R.id.total_cards_text)).setText(""
				+ (game.getDealer().CARD_PACKS * CardPack.CARDS_IN_PACK));

		((TextView) findViewById(R.id.bet_text)).setText(""
				+ game.getPlayer().getBet());
		((TextView) findViewById(R.id.balance_text)).setText(""
				+ game.getPlayer().getWallet());

		((TextView) findViewById(R.id.player_1_name_text)).setText(game
				.getDealer().getName());
		if (table.isShowAllDealerCards() == true) {
			((TextView) findViewById(R.id.player_1_score_text)).setText(""
					+ table.getDealer().getTotal());
		} else {
			((TextView) findViewById(R.id.player_1_score_text)).setText("" + 0);
		}

		((TextView) findViewById(R.id.player_2_name_text)).setText(game
				.getPlayer().getName());
		((TextView) findViewById(R.id.player_2_score_text)).setText(""
				+ table.getPlayer().getTotal());

		/*
		 * Draw dealer cards.
		 */
		int i = 0;
		for (ImageView view : player1cards) {
			view.setImageBitmap(null);
		}
		for (Card aCard : table.getDealer()) {
			player1cards[i].setImageResource(mapping.get(aCard.getCode()));
			i++;
		}
		if (table.isShowAllDealerCards() == false
				&& table.getDealer().size() > 0) {
			player1cards[0].setImageResource(R.drawable.red_back);
		}

		/*
		 * Draw player cards.
		 */
		for (ImageView view : player2cards) {
			view.setImageBitmap(null);
		}
		i = 0;
		for (Card aCard : table.getPlayer()) {
			player2cards[i].setImageResource(mapping.get(aCard.getCode()));
			i++;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		game = new Game(new Dealer(), new Player("James Bond", 32, "Male", 100));
		table = new Table();

		((Button) findViewById(R.id.one_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.increaseBet(1);
						updateViews();
					}
				});
		((Button) findViewById(R.id.five_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.increaseBet(5);
						updateViews();
					}
				});
		((Button) findViewById(R.id.ten_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.increaseBet(10);
						updateViews();
					}
				});
		((Button) findViewById(R.id.twenty_five_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.increaseBet(25);
						updateViews();
					}
				});
		((Button) findViewById(R.id.one_hundred_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.increaseBet(100);
						updateViews();
					}
				});

		((Button) findViewById(R.id.clear_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.clearBet();
						updateViews();
					}
				});

		((Button) findViewById(R.id.deal_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.newGame();
						updateViews();
					}
				});

		((Button) findViewById(R.id.hit_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.hit();
						updateViews();
					}
				});

		((Button) findViewById(R.id.double_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.playDouble();
						updateViews();
					}
				});

		((Button) findViewById(R.id.stand_button))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						game.stand();
						updateViews();
					}
				});

		updateViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_game, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.credit100) {
			game.getPlayer().setWallet(100 + game.getPlayer().getWallet());
			updateViews();
			startActivity(new Intent(this, InnerBannerActivity.class));
		} else if (itemId == R.id.update_player) {
			startActivity(new Intent(this, UpdatePlayerActivity.class));
		} else if (itemId == R.id.help) {
			startActivity(new Intent(this, HelpActivity.class));
		} else if (itemId == R.id.about) {
			startActivity(new Intent(this, AboutActivity.class));
		}
		return true;
	}
}
