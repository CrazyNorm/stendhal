package games.stendhal.server.maps.quests.revivalweeks;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.core.rp.StendhalQuestSystem;
import games.stendhal.server.entity.mapstuff.sign.Sign;
import games.stendhal.server.maps.quests.PaperChase;

/**
 * Adds a hall of fame sign for the paper chase
 *
 * @author hendrik
 */
public class PaperChaseSign {

	/**
	 * creates the hall of fame sign
	 */
	private void createHallOfFameSign() {
		Sign sign = new Sign();
		sign.setPosition(94, 110);
		StendhalRPZone zone = SingletonRepository.getRPWorld().getZone("0_semos_mountain_n2");
		zone.add(sign);
		PaperChase paperChase = (PaperChase) StendhalQuestSystem.get().getQuest("PaperChase");
		if (paperChase != null) {
			paperChase.setSign(sign);
		}
	}

	/**
	 * adds the sign to the world
	 */
	public void addToWorld() {
		createHallOfFameSign();
	}
}
