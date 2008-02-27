package games.stendhal.server.maps.kirdneh.museum;

import games.stendhal.common.Direction;
import games.stendhal.server.core.config.ZoneConfigurator;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.npc.ShopList;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.behaviour.adder.SellerAdder;
import games.stendhal.server.entity.npc.behaviour.impl.SellerBehaviour;

import java.util.Map;

/**
 * Builds a Curator NPC in Kirdneh museum .
 *
 * @author kymara
 */
public class CuratorNPC implements ZoneConfigurator {
	private ShopList shops = SingletonRepository.getShopList();
	//
	// ZoneConfigurator
	//

	/**
	 * Configure a zone.
	 *
	 * @param zone
	 *            The zone to be configured.
	 * @param attributes
	 *            Configuration attributes.
	 */
	public void configureZone(StendhalRPZone zone,
			Map<String, String> attributes) {
		buildNPC(zone, attributes);
	}

	private void buildNPC(StendhalRPZone zone, Map<String, String> attributes) {
		SpeakerNPC npc = new SpeakerNPC("Hazel") {

			@Override
			protected void createPath() {
				setPath(null);
			}

			@Override
			protected void createDialog() {
				addGreeting("Welcome to Kirdneh Museum.");
				addJob("I am the curator of this museum. That means I organise the displays and look for new #exhibits.");
				addHelp("This is a place for rare artefacts and special #exhibits.");
				// remaining behaviour defined in games.stendhal.server.maps.quests.WeeklyItemQuest
				new SellerAdder().addSeller(this, new SellerBehaviour(shops.get("kirdnehscrolls")));
				addGoodbye("Good bye, it was pleasant talking with you.");
			}
		};

		npc.setEntityClass("curatornpc");
		npc.setPosition(2, 38);
		npc.setDirection(Direction.RIGHT);
		npc.initHP(100);
		zone.add(npc);
	}
}
