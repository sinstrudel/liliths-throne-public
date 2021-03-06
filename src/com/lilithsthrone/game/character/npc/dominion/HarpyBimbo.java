package com.lilithsthrone.game.character.npc.dominion;

import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.QuestLine;
import com.lilithsthrone.game.character.SexualOrientation;
import com.lilithsthrone.game.character.body.Covering;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.valueEnums.AssSize;
import com.lilithsthrone.game.character.body.valueEnums.Capacity;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.HipSize;
import com.lilithsthrone.game.character.body.valueEnums.Wetness;
import com.lilithsthrone.game.character.effects.Fetish;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.combat.Attack;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.places.dominion.harpyNests.HarpyNestBimbo;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.game.inventory.item.AbstractItemType;
import com.lilithsthrone.game.inventory.item.ItemType;
import com.lilithsthrone.game.sex.SexPace;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.HarpyNests;

/**
 * @since 0.1.8
 * @version 0.1.8
 * @author Innoxia
 */
public class HarpyBimbo extends NPC {

	private static final long serialVersionUID = 1L;

	public HarpyBimbo() {
		super(new NameTriplet("Brittany"),
				"One of the more notable harpy matriarchs, Brittany is the leader of a flock of harpies."
						+ " In order to get into her good graces, most of her flock try to mimic her behaviour and appearance."
						+ " As a result, Brittany's flock is primarily made up of bleach-blonde bimbos.",
				7, Gender.F_V_B_FEMALE, RacialBody.HARPY, RaceStage.LESSER,
				new CharacterInventory(30), WorldType.HARPY_NEST, HarpyNests.HARPY_NEST_YELLOW, true);

		this.setSexualOrientation(SexualOrientation.AMBIPHILIC);

		this.addFetish(Fetish.FETISH_BIMBO);
		
		this.setEyeCovering(new Covering(BodyCoveringType.EYE_HARPY, Colour.EYE_BLUE));
		this.setHairCovering(new Covering(BodyCoveringType.HAIR_HARPY, Colour.FEATHERS_BLEACH_BLONDE), true);
		this.setSkinCovering(new Covering(BodyCoveringType.FEATHERS, Colour.FEATHERS_BLEACH_BLONDE), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, Colour.SKIN_LIGHT), true);
		
		this.setFemininity(95);
		
		this.setVaginaVirgin(false);
		this.setVaginaWetness(Wetness.THREE_WET.getValue());
		this.setVaginaCapacity(Capacity.THREE_SLIGHTLY_LOOSE.getMedianValue());
		
		this.setAssVirgin(false);
		this.setFaceVirgin(false);
		this.setBreastSize(CupSize.DD.getMeasurement());
		this.setAssSize(AssSize.FIVE_HUGE.getValue());
		this.setHipSize(HipSize.FIVE_VERY_WIDE.getValue());
		
		this.setHeight(160);
		
		this.setPiercedEar(true);
		this.setPiercedNavel(true);

		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.EYES_AVIATORS, Colour.CLOTHING_GOLD, false), true, this);
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.GROIN_VSTRING, Colour.CLOTHING_WHITE, false), true, this);
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.CHEST_CROPTOP_BRA, Colour.CLOTHING_WHITE, false), true, this);
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.TORSO_CAMITOP_STRAPS, Colour.CLOTHING_BLUE_LIGHT, false), true, this);
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.LEG_MICRO_SKIRT_BELTED, Colour.CLOTHING_BLUE_LIGHT, false), true, this);
		
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.PIERCING_EAR_BASIC_RING, Colour.CLOTHING_SILVER, false), true, this);
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.PIERCING_NAVEL_GEM, Colour.CLOTHING_SILVER, false), true, this);
	}
	
	@Override
	public String getSpeechColour() {
		if(Main.getProperties().lightTheme) {
			return "#D60AB8";
			
		} else {
			return "#F967E3";
		}
	}
	
	@Override
	public boolean isAbleToBeImpregnated() {
		return true;
	}
	
	@Override
	public void changeFurryLevel(){
	}
	
	@Override
	public DialogueNodeOld getEncounterDialogue() {
		return null;
	}

	@Override
	public void endSex(boolean applyEffects) {
	}
	
	@Override
	public SexPace getSexPaceSubPreference(){
		return SexPace.SUB_EAGER;
	}

	// Combat:
	
	public int getEscapeChance() {
		return 0;
	}
	
	@Override
	public Attack attackType() {
		if(!getSpecialAttacks().isEmpty()) {
			if (Math.random() < 0.4) {
				return Attack.MAIN;
			} else if (Math.random() < 0.8) {
				return Attack.SEDUCTION;
			} else {
				return Attack.SPECIAL_ATTACK;
			}
			
		} else {
			if (Math.random() < 0.5) {
				return Attack.MAIN;
			} else {
				return Attack.SEDUCTION;
			}
		}
	}

	@Override
	public String getCombatDescription() {
		return UtilText.parse(this,
				"After watching you defeat [bimboHarpyCompanion.name], [bimboHarpy.name] rushes forwards, determined to teach you a lesson in front of her flock of bimbo harpies.");
	}

	@Override
	public String getAttackDescription(Attack attackType, boolean isHit) {

		if (attackType == Attack.MAIN) {
			switch (Util.random.nextInt(3)) {
			case 0:
				return UtilText.parse(this,
						"<p>"
							+ "[npc.Name] feints a punch, and as you dodge away, [npc.she] tries to deliver a kick aimed at your legs."
							+ (isHit ? "" : " You see [npc.her] kick coming and jump backwards out of harm's way.")
						+ "</p>");
			case 1:
				return UtilText.parse(this,
						"<p>"
							+ "[npc.Name] jumps forwards, trying to deliver a punch to your stomach."
							+ (isHit ? "" : " You manage to twist to one side, narrowly avoiding [npc.her] attack.")
						+ "</p>");
			default:
				return UtilText.parse(this,
						"<p>"
							+ "[npc.Name] darts forwards, throwing a punch at your torso."
							+ (isHit ? "" : " You manage to dodge [npc.her] attack by leaping to one side.")
						+ "</p>");
			}
		} else {
			if(isFeminine()) {
				switch (Util.random.nextInt(3)) {
					case 0:
						return UtilText.parse(this,
								"<p>"
									+ "[npc.Name] erotically runs [npc.her] hands down [npc.her] legs and bends forwards as [npc.she] teases you, "
									+ "[npc.speech(Come on baby, I can show you a good time!)]"
								+ "</p>");
					case 1:
						return UtilText.parse(this,
								"<p>"
									+ "[npc.Name] pushes out [npc.her] chest and lets out an erotic moan, "
									+ "[npc.speech(Come play with me!)]"
								+ "</p>");
					default:
						return UtilText.parse(this,
								"<p>"
									+ "[npc.Name] slowly runs [npc.her] hands down between [npc.her] thighs, "
									+ "[npc.speech(You know you want it!)]"
								+ "</p>");
				}
			} else {
				switch (Util.random.nextInt(3)) {
					case 0:
						return UtilText.parse(this,
								"<p>"
									+ "[npc.Name] winks at you and flexes [npc.his] muscles, "
									+ "[npc.speech(My body's aching for your touch!)]"
								+ "</p>");
					case 1:
						return UtilText.parse(this,
								"<p>"
									+ "[npc.Name] strikes a heroic pose before blowing a kiss your way, "
									+ "[npc.speech(Come on, I can show you a good time!)]"
								+ "</p>");
					default:
						return UtilText.parse(this,
								"<p>"
									+ "[npc.Name] grins at you as [npc.he] reaches down and grabs [npc.his] crotch, "
									+ "[npc.speech(You know you want a taste of this!)]"
								+ "</p>");
				}

			}
		}
	}
	
	@Override
	public Response endCombat(boolean applyEffects, boolean victory) {
		if (victory) {
			return new Response("", "", HarpyNestBimbo.HARPY_NEST_BIMBO_FIGHT_BEAT_BIMBO) {
				@Override
				public void effects() {
					Main.game.getDialogueFlags().bimboPacified = true;
					Main.game.getTextEndStringBuilder().append(Main.game.getPlayer().addItem(AbstractItemType.generateItem(ItemType.HARPY_MATRIARCH_BIMBO_LOLLIPOP), false));
				}
				@Override
				public QuestLine getQuestLine() {
					return QuestLine.SIDE_HARPY_PACIFICATION;
				}
			};
		} else {
			return new Response("", "", HarpyNestBimbo.HARPY_NEST_BIMBO_FIGHT_LOSE_TO_MATRIARCH);
		}
	}

}