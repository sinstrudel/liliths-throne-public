package com.lilithsthrone.game.character.npc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lilithsthrone.game.character.CharacterUtils;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.History;
import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.SexualOrientation;
import com.lilithsthrone.game.character.attributes.AffectionLevel;
import com.lilithsthrone.game.character.attributes.Attribute;
import com.lilithsthrone.game.character.attributes.CorruptionLevel;
import com.lilithsthrone.game.character.attributes.FitnessLevel;
import com.lilithsthrone.game.character.attributes.IntelligenceLevel;
import com.lilithsthrone.game.character.attributes.ObedienceLevel;
import com.lilithsthrone.game.character.attributes.StrengthLevel;
import com.lilithsthrone.game.character.body.Antenna;
import com.lilithsthrone.game.character.body.Arm;
import com.lilithsthrone.game.character.body.Ass;
import com.lilithsthrone.game.character.body.Body;
import com.lilithsthrone.game.character.body.Breast;
import com.lilithsthrone.game.character.body.Ear;
import com.lilithsthrone.game.character.body.Eye;
import com.lilithsthrone.game.character.body.Face;
import com.lilithsthrone.game.character.body.Hair;
import com.lilithsthrone.game.character.body.Horn;
import com.lilithsthrone.game.character.body.Leg;
import com.lilithsthrone.game.character.body.Penis;
import com.lilithsthrone.game.character.body.Skin;
import com.lilithsthrone.game.character.body.Tail;
import com.lilithsthrone.game.character.body.Vagina;
import com.lilithsthrone.game.character.body.Wing;
import com.lilithsthrone.game.character.body.types.AntennaType;
import com.lilithsthrone.game.character.body.types.ArmType;
import com.lilithsthrone.game.character.body.types.AssType;
import com.lilithsthrone.game.character.body.types.BreastType;
import com.lilithsthrone.game.character.body.types.EarType;
import com.lilithsthrone.game.character.body.types.EyeType;
import com.lilithsthrone.game.character.body.types.FaceType;
import com.lilithsthrone.game.character.body.types.HairType;
import com.lilithsthrone.game.character.body.types.HornType;
import com.lilithsthrone.game.character.body.types.LegType;
import com.lilithsthrone.game.character.body.types.PenisType;
import com.lilithsthrone.game.character.body.types.SkinType;
import com.lilithsthrone.game.character.body.types.TailType;
import com.lilithsthrone.game.character.body.types.VaginaType;
import com.lilithsthrone.game.character.body.types.WingType;
import com.lilithsthrone.game.character.body.valueEnums.AssSize;
import com.lilithsthrone.game.character.body.valueEnums.BreastShape;
import com.lilithsthrone.game.character.body.valueEnums.CumProduction;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.Femininity;
import com.lilithsthrone.game.character.body.valueEnums.HairLength;
import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
import com.lilithsthrone.game.character.body.valueEnums.HipSize;
import com.lilithsthrone.game.character.body.valueEnums.LabiaSize;
import com.lilithsthrone.game.character.body.valueEnums.LipSize;
import com.lilithsthrone.game.character.body.valueEnums.OrificeModifier;
import com.lilithsthrone.game.character.body.valueEnums.PenisSize;
import com.lilithsthrone.game.character.body.valueEnums.TesticleSize;
import com.lilithsthrone.game.character.body.valueEnums.Wetness;
import com.lilithsthrone.game.character.effects.Fetish;
import com.lilithsthrone.game.character.effects.Perk;
import com.lilithsthrone.game.character.effects.StatusEffect;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.race.Race;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.combat.Attack;
import com.lilithsthrone.game.combat.SpecialAttack;
import com.lilithsthrone.game.combat.Spell;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.AbstractCoreItem;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.CoverableArea;
import com.lilithsthrone.game.inventory.enchanting.EnchantingUtils;
import com.lilithsthrone.game.inventory.enchanting.TFEssence;
import com.lilithsthrone.game.inventory.enchanting.TFModifier;
import com.lilithsthrone.game.inventory.enchanting.TFPotency;
import com.lilithsthrone.game.inventory.item.AbstractItem;
import com.lilithsthrone.game.inventory.item.AbstractItemType;
import com.lilithsthrone.game.inventory.item.ItemEffect;
import com.lilithsthrone.game.inventory.item.ItemType;
import com.lilithsthrone.game.sex.LubricationType;
import com.lilithsthrone.game.sex.OrificeType;
import com.lilithsthrone.game.sex.PenetrationType;
import com.lilithsthrone.game.sex.Sex;
import com.lilithsthrone.game.sex.SexPace;
import com.lilithsthrone.game.sex.SexPosition;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.rendering.RenderingEngine;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Vector2i;
import com.lilithsthrone.utils.Util.ListValue;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.GenericPlace;
import com.lilithsthrone.world.places.PlaceInterface;
import com.lilithsthrone.world.places.PlaceUpgrade;

import java.util.Set;

/**
 * @since 0.1.0
 * @version 0.1.87
 * @author Innoxia
 */
public abstract class NPC extends GameCharacter {
	private static final long serialVersionUID = 1L;
	
	protected long lastTimeEncountered = -1;
	
	protected int romanceProgress = 0;
	
	protected float buyModifier, sellModifier;

	protected boolean knowsPlayerGender = false, addedToContacts, pendingClothingDressing;
	
	protected boolean reactedToPregnancy, reactedToPlayerPregnancy;
	
	protected Set<SexPosition> sexPositionPreferences;
	
	protected Body bodyPreference = null;
	
	public boolean flagSlaveBackground = false, flagSlaveSmallTalk = false,
						flagSlaveEncourage = false, flagSlaveHug = false, flagSlavePettings = false,
						flagSlaveInspect = false, flagSlaveSpanking = false, flagSlaveMolest = false;
	
	
	protected NPC(NameTriplet nameTriplet, String description, int level, Gender startingGender, RacialBody startingRace,
			RaceStage stage, CharacterInventory inventory, WorldType worldLocation, PlaceInterface startingPlace, boolean addedToContacts) {
		super(nameTriplet, description, level, startingGender, startingRace, stage, inventory, worldLocation, startingPlace);

		this.addedToContacts = addedToContacts;
		
		reactedToPregnancy = false;
		reactedToPlayerPregnancy = false;
		pendingClothingDressing = false;
		
		sexPositionPreferences = new HashSet<>();
		
		buyModifier=0.75f;
		sellModifier=1.5f;
		
		if(getLocation().equals(Main.game.getPlayer().getLocation()) && getWorldLocation()==Main.game.getPlayer().getWorldLocation()) {
			for(CoverableArea ca : CoverableArea.values()) {
				if(isCoverableAreaExposed(ca) && ca!=CoverableArea.MOUTH) {
					getPlayerKnowsAreasMap().put(ca, true);
				}
			}
		}
	}
	
	
	
	
	public void resetSlaveFlags() {
		flagSlaveBackground = false;
		flagSlaveSmallTalk = false;
		flagSlaveEncourage = false;
		flagSlaveHug = false;
		flagSlavePettings = false;
		flagSlaveInspect = false;
		flagSlaveSpanking = false;
		flagSlaveMolest = false;
	}
	
	/**
	 * Resets this character to their default state.
	 */
	public void dailyReset() {
	}

	public abstract void changeFurryLevel();
	
	public abstract DialogueNodeOld getEncounterDialogue();
	
	public void equipClothing(boolean replaceUnsuitableClothing, boolean onlyAddCoreClothing) {
		CharacterUtils.equipClothing(this, replaceUnsuitableClothing, onlyAddCoreClothing);
	}
	
	public boolean isClothingStealable() {
		return false;
	}
	
	public void setLocation(WorldType worldType, Vector2i location) {
		setWorldLocation(worldType);
		setLocation(location);
	}
	
	public void setLocation(WorldType worldType, PlaceInterface placeType) {
		setLocation(worldType, Main.game.getWorlds().get(worldType).getPlacesOfInterest().get(new GenericPlace(placeType)));
	}
	
	public void setLocation(WorldType worldType, GenericPlace place) {
		setLocation(worldType, Main.game.getWorlds().get(worldType).getPlacesOfInterest().get(place));
	}
	
	// Trader:

	public String getTraderDescription() {
		return UtilText.parse(this,
				"<p>"
					+ "You have a look at what [npc.name] has for sale."
				+ "</p>");
	}

	public boolean isTrader() {
		return false;
	}

	public boolean willBuy(AbstractCoreItem item) {
		return false;
	}
	
	/**
	 * Handles any extra effects that need to be taken into account when selling an item to the player.
	 * @param item
	 */
	public void handleSellingEffects(AbstractCoreItem item, int count, int itemPrice) {
	}

	public float getBuyModifier() {
		return buyModifier;
	}

	public void setBuyModifier(float buyModifier) {
		this.buyModifier = buyModifier;
	}

	public float getSellModifier() {
		return sellModifier;
	}

	public void setSellModifier(float sellModifier) {
		this.sellModifier = sellModifier;
	}

	// Combat:
	
	public abstract String getCombatDescription();

	public abstract String getAttackDescription(Attack attackType, boolean isHit);

	public abstract Response endCombat(boolean applyEffects, boolean victory);

	public abstract Attack attackType();

	public Spell getSpell() {
		return null;
	}
	
	public int getEscapeChance() {
		return 30;
	}

	public boolean isSurrendersAtZeroMana() {
		return true;
	}

	// Post-combat:

	public int getExperienceFromVictory() {
		if (Main.game.getPlayer().getLevel() - getLevel() >= 3) {
			return getLevel();
		} else {
			return (getLevel() * 2);
		}
	}

	public int getLootMoney() {
		return (int) ((getLevel() * 20) * (1 + Math.random() - 0.5f));
	}
	
	public List<AbstractCoreItem> getLootItems() {
		double rnd = Math.random();
		
		if(rnd <= 0.7) {
			switch(getRace()) {
				case CAT_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.INT_INGREDIENT_FELINE_FANCY)));
				case COW_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.STR_INGREDIENT_BUBBLE_MILK)));
				case DOG_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.FIT_INGREDIENT_CANINE_CRUSH)));
				case HORSE_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.STR_INGREDIENT_EQUINE_CIDER)));
				case WOLF_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.STR_INGREDIENT_WOLF_WHISKEY)));
				case HUMAN:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.INT_INGREDIENT_VANILLA_WATER)));
				case ANGEL:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.DYE_BRUSH)));
				case DEMON:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.COR_INGREDIENT_LILITHS_GIFT)));
				case HARPY:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.SEX_INGREDIENT_HARPY_PERFUME)));
				case SLIME:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.DYE_BRUSH)));
				case SQUIRREL_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.FIT_INGREDIENT_SQUIRREL_JAVA)));
			}
			
		} else if(rnd <= 0.8 && !Main.getProperties().isRaceDiscovered(getRace())) {
			switch(getRace()) {
				case CAT_MORPH:

					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_CAT_MORPH)));
				case COW_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_COW_MORPH)));
				case DOG_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_DOG_MORPH)));
				case HORSE_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_HORSE_MORPH)));
				case WOLF_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_WOLF_MORPH)));
				case HUMAN:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_HUMAN)));
				case ANGEL:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.DYE_BRUSH)));
				case DEMON:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_DEMON)));
				case HARPY:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_HARPY)));
				case SLIME:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.DYE_BRUSH)));
				case SQUIRREL_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.BOOK_SQUIRREL_MORPH)));
			}
		
		} else {
			switch(getRace()) {
				case CAT_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_CAT_MORPH)));
				case COW_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_COW_MORPH)));
				case DOG_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_DOG_MORPH)));
				case HORSE_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_HORSE_MORPH)));
				case WOLF_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_WOLF_MORPH)));
				case HUMAN:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_HUMAN)));
				case ANGEL:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_HUMAN)));
				case DEMON:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_DEMON)));
				case HARPY:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_HARPY)));
				case SLIME:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_HUMAN)));
				case SQUIRREL_MORPH:
					return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_SQUIRREL_MORPH)));
			}
		}
		
		return Util.newArrayListOfValues(new ListValue<>(AbstractItemType.generateItem(ItemType.DYE_BRUSH)));
	}
	
	public Map<TFEssence, Integer> getLootEssenceDrops() {
		return Util.newHashMapOfValues(new Value<>(TFEssence.ARCANE, Util.random.nextInt(2)+1));
	}
	
	
	// Relationships:
	
	public float getDailyAffectionChange() {
		// Forgive me, for I am tired x_x
		
		float affectionTrack = getAffection(Main.game.getPlayer());
		
		for(PlaceUpgrade upgrade : this.getLocationPlace().getPlaceUpgrades()) {
			if(upgrade.getAffectionCap()==null) {
				affectionTrack += upgrade.getAffectionGain();
				
			} else {
				if(upgrade.getAffectionGain()>0) {
					if(getAffection(Main.game.getPlayer()) < upgrade.getAffectionCap().getMaximumValue()) {
						if(getAffection(Main.game.getPlayer()) + upgrade.getAffectionGain() > upgrade.getAffectionCap().getMaximumValue()) {
							affectionTrack = upgrade.getAffectionCap().getMaximumValue();
						} else {
							affectionTrack += upgrade.getAffectionGain();
						}
					}
					
				} else if(upgrade.getAffectionGain()<0) {
					if(getAffection(Main.game.getPlayer()) > upgrade.getAffectionCap().getMinimumValue()) {
						if(getAffection(Main.game.getPlayer()) + upgrade.getAffectionGain() < upgrade.getAffectionCap().getMinimumValue()) {
							affectionTrack = upgrade.getAffectionCap().getMinimumValue();
						} else {
							affectionTrack += upgrade.getAffectionGain();
						}
					}
				}
			}
		}
		
		return affectionTrack - getAffection(Main.game.getPlayer());
	}
	
	
	// Misc:

	/**
	 * By default, NPCs can't be impregnated.
	 * 
	 * @return
	 */
	public boolean isAbleToBeImpregnated() {
		return false;
	}

	public boolean isKnowsPlayerGender() {
		return knowsPlayerGender;
	}

	public void setKnowsPlayerGender(boolean knowsPlayerGender) {
		this.knowsPlayerGender = knowsPlayerGender;
	}

	public long getLastTimeEncountered() {
		return lastTimeEncountered;
	}

	public void setLastTimeEncountered(long minutesPassed) {
		this.lastTimeEncountered = minutesPassed;
	}

	public int getRomanceProgress() {
		return romanceProgress;
	}

	public void setRomanceProgress(int romanceProgress) {
		this.romanceProgress = romanceProgress;
	}

	public boolean isAddedToContacts() {
		return addedToContacts;
	}
	
	public Body getPreferredBody() {
		if(bodyPreference == null) {
			regenerateBodyPreference();
		}
		
		return bodyPreference;
	}
	
	public void regenerateBodyPreference() {
		bodyPreference = generatePreferredBody();
	}
	
	/**
	 * Example return value: ["Let's give you bigger breasts!", AbstractItem]
	 * @return NPC's speech as a reaction to giving you this potion, along with the potion itself.
	 */
	public Value<String, AbstractItem> generateTransformativePotion() {
		
		/* TODO
		 * Body Size
		 * Muscle mass
		 * Penis modifiers
		 * Vagina modifiers
		 * Throat modifiers
		 */
		
		int numberOfTransformations = Main.game.getPlayer().hasFetish(Fetish.FETISH_TRANSFORMATION_RECEIVING)?2 + Util.random.nextInt(7):1 + Util.random.nextInt(4);
		List<ItemEffect> effects = new ArrayList<>();
		
		AbstractItemType itemType = ItemType.RACE_INGREDIENT_HUMAN;
		String reaction = "Time to transform you!", raceName = "human";
		
		if (getPreferredBody().getGender().isFeminine()) {
			raceName = getPreferredBody().getGender().getName() + " " + getPreferredBody().getRace().getSingularFemaleName();
		} else {
			raceName = getPreferredBody().getGender().getName() + " " + getPreferredBody().getRace().getSingularMaleName();
		}
		
		switch(getPreferredBody().getRace()) {
			case CAT_MORPH:
				itemType = ItemType.RACE_INGREDIENT_CAT_MORPH;
				reaction = "Time to turn you into a cute little "+raceName+"!";
				break;
			case DOG_MORPH:
				itemType = ItemType.RACE_INGREDIENT_DOG_MORPH;
				reaction = "Time to turn you into an excitable little "+raceName+"!";
				break;
			case HARPY:
				itemType = ItemType.RACE_INGREDIENT_HARPY;
				reaction = "Time to turn you into a hot little "+raceName+"!";
				break;
			case HORSE_MORPH:
				itemType = ItemType.RACE_INGREDIENT_HORSE_MORPH;
				if (getPreferredBody().getGender().isFeminine()) {
					reaction = "Time to turn you into my little mare!";
				} else {
					reaction = "Time to turn you into my very own stallion!";
				}
				break;
			case SQUIRREL_MORPH:
				itemType = ItemType.RACE_INGREDIENT_SQUIRREL_MORPH;
				reaction = "Time to turn you into a cute little "+raceName+"!";
				break;
			case WOLF_MORPH:
				itemType = ItemType.RACE_INGREDIENT_WOLF_MORPH;
				reaction = "Time to turn you into a "+raceName+"!";
				break;
			case COW_MORPH:
				itemType = ItemType.RACE_INGREDIENT_COW_MORPH;
				break;
			case ANGEL:
			case DEMON:
			case SLIME:
			case HUMAN:
				itemType = ItemType.RACE_INGREDIENT_HUMAN;
				break;
		}
		
		Map<ItemEffect, String> possibleEffects = new HashMap<>();
		
		// Order of transformation preferences are: Sexual organs -> minor parts -> Legs & arms -> Face & skin 

		// Sexual transformations:
		boolean removingVagina = false;
		boolean addingVagina = false;
		boolean removingPenis = false;
		boolean addingPenis = false;
		if(!Main.game.getPlayer().isHasAnyPregnancyEffects()) { // Vagina cannot be transformed if pregnant, so skip this
			if(Main.game.getPlayer().getVaginaType() != getPreferredBody().getVagina().getType()) {
				if(getPreferredBody().getVagina().getType() == VaginaType.NONE) {
					if(Main.game.getPlayer().getVaginaRawCapacityValue() > 1) {
						possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_VAGINA, TFModifier.TF_MOD_CAPACITY, TFPotency.DRAIN, 1), "Let's get to work on getting rid of that little cunt of yours!");
						removingVagina = true;
					} else {
						possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_VAGINA, TFModifier.REMOVAL, TFPotency.MINOR_BOOST, 1), "Let's get rid of that tight little cunt of yours!");
						removingVagina = true;
					}
				} else {
					possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_VAGINA, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), "Let's give you a nice "+getPreferredBody().getVagina().getName(Main.game.getPlayer(), false)+"!");
					addingVagina = true;
				}
			}
		}
		if(Main.game.getPlayer().getPenisType() != getPreferredBody().getPenis().getType()) {
			if(getPreferredBody().getPenis().getType() == PenisType.NONE) {
				if(Main.game.getPlayer().getPenisRawSizeValue() > 1) {
					possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_PENIS, TFModifier.TF_MOD_SIZE, TFPotency.DRAIN, 1), "Let's get to work on getting rid of that cock of yours!");
					removingPenis = true;
				} else {
					possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_PENIS, TFModifier.REMOVAL, TFPotency.MINOR_BOOST, 1), "Let's get rid of that pathetic little cock of yours!");
					removingPenis = true;
				}
			} else {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_PENIS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), "Let's give you a nice "+getPreferredBody().getPenis().getName(Main.game.getPlayer(), false)+"!");
				addingPenis = true;
			}
		}
		if(!possibleEffects.isEmpty()) {
			String s = "";
			if(possibleEffects.size()>1) {
				if(removingVagina) {
					s+="Let's get to work on getting rid of that cunt of yours,";
					if(removingPenis) {
						s+=" and I thinking it's also time to say goodbye to your pathetic cock as well!";
					} else if(addingPenis) {
						s+=" and give you a nice cock instead!";
					}
				} else if(addingVagina) {
					s+="Let's give you a "+getPreferredBody().getVagina().getName(Main.game.getPlayer(), false)+",";
					if(removingPenis) {
						s+=" and I think I'll get rid of your pathetic cock at the same time!";
					} else if(addingPenis) {
						s+=" and a nice cock as well!";
					}
				}
			}
			
			for(Entry<ItemEffect, String> entry : possibleEffects.entrySet()) {
				if(possibleEffects.size()==1){
					s = entry.getValue();
				}
				effects.add(entry.getKey());
			}
			return new Value<>(s, EnchantingUtils.craftItem(AbstractItemType.generateItem(itemType), effects));
		}
		
		// All minor part transformations:
		if(possibleEffects.isEmpty() || Math.random()>0.33f) {
			if(Main.game.getPlayer().getAntennaType() != getPreferredBody().getAntenna().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_ANTENNA, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getAssType() != getPreferredBody().getAss().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_ASS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getBreastType() != getPreferredBody().getBreast().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_BREASTS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getEarType() != getPreferredBody().getEar().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_EARS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getEyeType() != getPreferredBody().getEye().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_EYES, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getHairType() != getPreferredBody().getHair().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_HAIR, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getHornType() != getPreferredBody().getHorn().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_HORNS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getTailType() != getPreferredBody().getTail().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_TAIL, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getWingType() != getPreferredBody().getWing().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_WINGS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
		}
		// Leg & Arm transformations:
		if(possibleEffects.isEmpty()) {
			if(Main.game.getPlayer().getArmType() != getPreferredBody().getArm().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_ARMS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getLegType() != getPreferredBody().getLeg().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_LEGS, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
		}
		// Face & Skin transformations:
		if(possibleEffects.isEmpty()) {
			if(Main.game.getPlayer().getSkinType() != getPreferredBody().getSkin().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_SKIN, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
			if(Main.game.getPlayer().getFaceType() != getPreferredBody().getFace().getType()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_FACE, TFModifier.NONE, TFPotency.MINOR_BOOST, 1), reaction);
			}
		}
		
		// 50% chance of type TF:
		if(Math.random()<0.5f && !possibleEffects.isEmpty()) {
			List<ItemEffect> keysAsArray = new ArrayList<>(possibleEffects.keySet());
			
			for (int i = 0 ; i < numberOfTransformations ; i++) {
				if(!keysAsArray.isEmpty()) {
					ItemEffect e = keysAsArray.get(Util.random.nextInt(keysAsArray.size()));
					effects.add(e);
					keysAsArray.remove(e);
				}
			}
			
			return new Value<>(
					reaction,
					EnchantingUtils.craftItem(AbstractItemType.generateItem(itemType), effects));
		}
		
		
		// Other transformations:
		
		// Femininity:
		if(Main.game.getPlayer().getFemininityValue() < getPreferredBody().getFemininity() && Femininity.valueOf(Main.game.getPlayer().getFemininityValue()) != Femininity.valueOf(getPreferredBody().getFemininity())) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_CORE, TFModifier.TF_MOD_FEMININITY, TFPotency.BOOST, 1), "I'm gonna need you to be more feminine!");
			
		} else if(Main.game.getPlayer().getFemininityValue() > getPreferredBody().getFemininity() && Femininity.valueOf(Main.game.getPlayer().getFemininityValue()) != Femininity.valueOf(getPreferredBody().getFemininity())) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_CORE, TFModifier.TF_MOD_FEMININITY, TFPotency.DRAIN, 1), "I'm gonna need you to be more of a man!");
		}
		
		// Height:
		if(Main.game.getPlayer().getHeightValue() < getPreferredBody().getHeightValue() && (getPreferredBody().getHeightValue() - Main.game.getPlayer().getHeightValue() > 5)) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_CORE, TFModifier.TF_MOD_SIZE, TFPotency.BOOST, 1), "Let's make you a little taller!");
			
		} else if(Main.game.getPlayer().getHeightValue() > getPreferredBody().getHeightValue() && (Main.game.getPlayer().getHeightValue() - getPreferredBody().getHeightValue() > 5)) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_CORE, TFModifier.TF_MOD_SIZE, TFPotency.DRAIN, 1), "Let's make you a little shorter!");
		}
		
		// Breast size:
		if(Main.game.getPlayer().getBreastSize().getMeasurement() < getPreferredBody().getBreast().getSize().getMeasurement()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_BREASTS, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_BOOST, 1), "Your breasts need to be bigger!");
			
		} else if(Main.game.getPlayer().getBreastSize().getMeasurement() > getPreferredBody().getBreast().getSize().getMeasurement()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_BREASTS, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_DRAIN, 1), "Your breasts are too big!");
		}
		
		// Ass size:
		if(Main.game.getPlayer().getAssSize().getValue() < getPreferredBody().getAss().getAssSize().getValue()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_ASS, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_BOOST, 1), "Your ass needs to be bigger");
			
		} else if(Main.game.getPlayer().getAssSize().getValue() > getPreferredBody().getAss().getAssSize().getValue()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_ASS, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_DRAIN, 1), "Your ass is too big!");
		}
		
		// Hip size:
		if(Main.game.getPlayer().getHipSize().getValue() < getPreferredBody().getAss().getHipSize().getValue()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_ASS, TFModifier.TF_MOD_SIZE_SECONDARY, TFPotency.MINOR_BOOST, 1), "Your hips need to be wider!");
			
		} else if(Main.game.getPlayer().getHipSize().getValue() > getPreferredBody().getAss().getHipSize().getValue()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_ASS, TFModifier.TF_MOD_SIZE_SECONDARY, TFPotency.MINOR_DRAIN, 1), "Your hips are too wide!");
		}
		

		if(Main.game.getPlayer().getPenisType() != PenisType.NONE && getPreferredBody().getPenis().getType() != PenisType.NONE) {
			// Penis size:
			if(Main.game.getPlayer().getPenisRawSizeValue() < getPreferredBody().getPenis().getRawSizeValue()) {
				if(getPreferredBody().getPenis().getRawSizeValue() - Main.game.getPlayer().getPenisRawSizeValue() > 5) {
					possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_PENIS, TFModifier.TF_MOD_SIZE, TFPotency.BOOST, 1), "Your cock needs to be a lot bigger!");
				} else {
					possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_PENIS, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_BOOST, 1), "Your cock needs to be a little bigger!");
				}
				
			} else if(Main.game.getPlayer().getPenisRawSizeValue() > getPreferredBody().getPenis().getRawSizeValue()) {
				if(Main.game.getPlayer().getPenisRawSizeValue() - getPreferredBody().getPenis().getRawSizeValue() > 5) {
					possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_PENIS, TFModifier.TF_MOD_SIZE, TFPotency.DRAIN, 1), "Your cock needs to be a lot smaller!");
				} else {
					possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_PENIS, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_DRAIN, 1), "Your cock needs to be a little smaller!");
				}
			}
		}
		
		if(Main.game.getPlayer().getVaginaType() != VaginaType.NONE && getPreferredBody().getVagina().getType() != VaginaType.NONE) {
			// Vagina wetness:
			if(Main.game.getPlayer().getVaginaWetness().getValue() < getPreferredBody().getVagina().getOrificeVagina().getWetness(Main.game.getGenericAndrogynousNPC()).getValue()) {
				possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_VAGINA, TFModifier.TF_MOD_WETNESS, TFPotency.MINOR_BOOST, 1), "Your pussy isn't wet enough!");
			}
		}
		
		// Hair length:
		if(Main.game.getPlayer().getHairRawLengthValue() < getPreferredBody().getHair().getRawLengthValue() && (getPreferredBody().getHair().getRawLengthValue() - Main.game.getPlayer().getHairRawLengthValue() > 5)) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_HAIR, TFModifier.TF_MOD_SIZE, TFPotency.BOOST, 1), "Your [pc.hair] "+(Main.game.getPlayer().getHairType().isDefaultPlural()?"are":"is")+" too short!");
			
		} else if(Main.game.getPlayer().getHairRawLengthValue() > getPreferredBody().getHair().getRawLengthValue() && (Main.game.getPlayer().getHairRawLengthValue() - getPreferredBody().getHair().getRawLengthValue() > 5)) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_HAIR, TFModifier.TF_MOD_SIZE, TFPotency.DRAIN, 1), "Your [pc.hair] "+(Main.game.getPlayer().getHairType().isDefaultPlural()?"are":"is")+" too long!");
		}
		
		// Lip size:
		if(Main.game.getPlayer().getLipSize().getValue() < getPreferredBody().getFace().getMouth().getLipSize().getValue()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_FACE, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_BOOST, 1), "Your [pc.lips] are too small!");
			
		} else if(Main.game.getPlayer().getLipSize().getValue() > getPreferredBody().getFace().getMouth().getLipSize().getValue()) {
			possibleEffects.put(new ItemEffect(itemType.getEnchantmentEffect(), TFModifier.TF_FACE, TFModifier.TF_MOD_SIZE, TFPotency.MINOR_DRAIN, 1), "Your [pc.lips] are too big!");
		}
		
		if(possibleEffects.isEmpty()) {
			return null;
		}
		
		List<ItemEffect> keysAsArray = new ArrayList<>(possibleEffects.keySet());
		ItemEffect effect = keysAsArray.get(Util.random.nextInt(keysAsArray.size()));
		
		for (int i = 0 ; i < numberOfTransformations ; i++) {
			if(!keysAsArray.isEmpty()) {
				ItemEffect e = keysAsArray.get(Util.random.nextInt(keysAsArray.size()));
				effects.add(e);
				keysAsArray.remove(e);
			}
		}
		
		return new Value<>(
				possibleEffects.get(effect),
				EnchantingUtils.craftItem(AbstractItemType.generateItem(itemType), effects));
	}
	
	private Body generatePreferredBody() {
		
		// Preferred gender:
		
		Gender preferredGender = Gender.N_P_V_B_HERMAPHRODITE;
		Map<Gender, Integer> desiredGenders = new HashMap<>();
		
		switch(this.getSexualOrientation()) {
			case AMBIPHILIC:
				if(this.isFeminine()) {
					desiredGenders.put(Gender.M_P_MALE, 14);
					desiredGenders.put(Gender.M_P_V_HERMAPHRODITE, 2);
					desiredGenders.put(Gender.M_V_CUNTBOY, 2);
					desiredGenders.put(Gender.F_P_TRAP, 2);
				} else {
					desiredGenders.put(Gender.F_V_B_FEMALE, 14);
					desiredGenders.put(Gender.F_P_V_B_FUTANARI, 2);
					desiredGenders.put(Gender.F_P_B_SHEMALE, 2);
					desiredGenders.put(Gender.F_P_TRAP, 2);
				}
				break;
			case ANDROPHILIC:
				desiredGenders.put(Gender.M_P_MALE, 16);
				desiredGenders.put(Gender.M_P_V_HERMAPHRODITE, 2);
				desiredGenders.put(Gender.M_V_CUNTBOY, 2);
				break;
			case GYNEPHILIC:
				desiredGenders.put(Gender.F_V_B_FEMALE, 14);
				desiredGenders.put(Gender.F_P_V_B_FUTANARI, 2);
				desiredGenders.put(Gender.F_P_B_SHEMALE, 2);
				desiredGenders.put(Gender.F_P_TRAP, 2);
				break;
		}
		
		int total = 0;
		for(Entry<Gender, Integer> entry : desiredGenders.entrySet()) {
			total+=entry.getValue();
		}
		int count = Util.random.nextInt(total)+1;
		total = 0;
		for(Entry<Gender, Integer> entry : desiredGenders.entrySet()) {
			if(total < count && total+entry.getValue()>= count) {
				preferredGender = entry.getKey();
				break;
			}
			total+=entry.getValue();
		}
		
		
		// Preferred race:
		
		Race race = getRace();
		
		// Chance for predator races to prefer prey races:
		if(getRace()==Race.CAT_MORPH && Math.random()>0.6f) {
			race = Race.HARPY;
		}
		if((getRace()==Race.WOLF_MORPH || getRace()==Race.DOG_MORPH) && Math.random()>0.6f) {
			List<Race> availableRaces = new ArrayList<>();
			availableRaces.add(Race.CAT_MORPH);
			availableRaces.add(Race.HARPY);
			availableRaces.add(Race.SQUIRREL_MORPH);
			race = availableRaces.get(Util.random.nextInt(availableRaces.size()));
		}
		
		// Chance for race to be random:
		if(Math.random()>0.85f) {
			List<Race> availableRaces = new ArrayList<>();
			availableRaces.add(Race.CAT_MORPH);
			availableRaces.add(Race.DOG_MORPH);
			availableRaces.add(Race.HARPY);
			availableRaces.add(Race.HORSE_MORPH);
			availableRaces.add(Race.HUMAN);
			availableRaces.add(Race.SQUIRREL_MORPH);
			availableRaces.add(Race.WOLF_MORPH);
			race = availableRaces.get(Util.random.nextInt(availableRaces.size()));
		}
		
		RacialBody startingBodyType = RacialBody.valueOfRace(race);
		
		
		// Preferred race stage:
		
		RaceStage stage = getRaceStage();
		
		if(preferredGender.isFeminine()) {
			switch(Main.getProperties().raceFemininePreferencesMap.get(race)) {
				case HUMAN:
					stage = RaceStage.HUMAN;
					break;
				case MAXIMUM:
					stage = RaceStage.GREATER;
					break;
				case MINIMUM:
					stage = RaceStage.PARTIAL_FULL;
					break;
				case NORMAL:
					stage = RaceStage.GREATER;
					break;
				case REDUCED:
					stage = RaceStage.LESSER;
					break;
			}
		} else {
			switch(Main.getProperties().raceMasculinePreferencesMap.get(race)) {
				case HUMAN:
					stage = RaceStage.HUMAN;
					break;
				case MAXIMUM:
					stage = RaceStage.GREATER;
					break;
				case MINIMUM:
					stage = RaceStage.PARTIAL_FULL;
					break;
				case NORMAL:
					stage = RaceStage.GREATER;
					break;
				case REDUCED:
					stage = RaceStage.LESSER;
					break;
			}
		}
		
		
		Body body = new Body.BodyBuilder(
				new Arm((stage.isArmFurry()?startingBodyType.getArmType():ArmType.HUMAN), startingBodyType.getArmRows()),
				new Ass(stage.isAssFurry()?startingBodyType.getAssType():AssType.HUMAN,
						(preferredGender.isFeminine() ? startingBodyType.getFemaleAssSize() : startingBodyType.getMaleAssSize()),
						startingBodyType.getAnusWetness(),
						startingBodyType.getAnusCapacity(),
						startingBodyType.getAnusElasticity(),
						startingBodyType.getAnusPlasticity(),
						true),
				new Breast(stage.isBreastFurry()?startingBodyType.getBreastType():BreastType.HUMAN,
						BreastShape.getRandomBreastShape(),
						(preferredGender.isFeminine() ? startingBodyType.getBreastSize() : startingBodyType.getNoBreastSize()),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleLactationRate() : startingBodyType.getMaleLactationRate()),
						((stage.isSkinFurry() && Main.getProperties().multiBreasts==1) || (stage.isBreastFurry() && Main.getProperties().multiBreasts==2)
								?(preferredGender.isFeminine() ? startingBodyType.getBreastCountFemale() : startingBodyType.getBreastCountMale())
								:1),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleNippleSize() : startingBodyType.getMaleNippleSize()),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleNippleShape() : startingBodyType.getMaleNippleShape()),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleAreolaeSize() : startingBodyType.getMaleAreolaeSize()),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleNippleCountPerBreast() : startingBodyType.getMaleNippleCountPerBreast()),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleBreastCapacity() : startingBodyType.getMaleBreastCapacity()),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleBreastElasticity() : startingBodyType.getMaleBreastElasticity()),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleBreastPlasticity() : startingBodyType.getMaleBreastPlasticity()), 
						true),
				new Face((stage.isFaceFurry()?startingBodyType.getFaceType():FaceType.HUMAN),
						(preferredGender.isFeminine() ? startingBodyType.getFemaleLipSize() : startingBodyType.getMaleLipSize())),
				new Eye(stage.isEyeFurry()?startingBodyType.getEyeType():EyeType.HUMAN),
				new Ear(stage.isEarFurry()?startingBodyType.getEarType():EarType.HUMAN),
				new Hair(stage.isHairFurry()?startingBodyType.getHairType():HairType.HUMAN,
						(preferredGender.isFeminine() ? startingBodyType.getFemaleHairLength() : startingBodyType.getMaleHairLength()),
						HairStyle.getRandomHairStyle((preferredGender.isFeminine() ? startingBodyType.getFemaleHairLength() : startingBodyType.getMaleHairLength()))),
				new Leg(stage.isLegFurry()?startingBodyType.getLegType():LegType.HUMAN),
				new Skin(stage.isSkinFurry()?startingBodyType.getSkinType():SkinType.HUMAN),
				startingBodyType.getBodyMaterial(),
				startingBodyType.getGenitalArrangement(),
				(preferredGender.isFeminine() ? startingBodyType.getFemaleHeight() : startingBodyType.getMaleHeight()),
				(preferredGender.isFeminine() ? startingBodyType.getFemaleFemininity() : startingBodyType.getMaleFemininity()),
				(preferredGender.isFeminine() ? startingBodyType.getFemaleBodySize() : startingBodyType.getMaleBodySize()),
				(preferredGender.isFeminine() ? startingBodyType.getFemaleMuscle() : startingBodyType.getMaleMuscle()))
						.vagina((preferredGender.getGenderName().isHasVagina())
								? new Vagina(stage.isVaginaFurry()?startingBodyType.getVaginaType():VaginaType.HUMAN,
										LabiaSize.getRandomLabiaSize().getValue(),
										startingBodyType.getClitSize(),
										startingBodyType.getVaginaWetness(),
										startingBodyType.getVaginaCapacity(),
										startingBodyType.getVaginaElasticity(),
										startingBodyType.getVaginaPlasticity(),
										true)
								: new Vagina(VaginaType.NONE, 0, 0, 0, 0, 3, 3, true))
						.penis((preferredGender.getGenderName().isHasPenis())
								? new Penis(stage.isPenisFurry()?startingBodyType.getPenisType():PenisType.HUMAN,
									startingBodyType.getPenisSize(),
									startingBodyType.getTesticleSize(),
									startingBodyType.getCumProduction(),
									startingBodyType.getTesticleQuantity())
								: new Penis(PenisType.NONE, 0, 0, 0, 2))
						.horn(startingBodyType.getHornTypeFemale() == HornType.NONE ? new Horn(HornType.NONE) : new Horn(!preferredGender.isFeminine()
								? (stage.isHornFurry()?startingBodyType.getHornTypeMale():HornType.NONE)
								: (stage.isHornFurry()?startingBodyType.getHornTypeFemale():HornType.NONE)))
						.antenna(new Antenna(stage.isAntennaFurry()?startingBodyType.getAntennaType():AntennaType.NONE))
						.tail(new Tail(stage.isTailFurry()?startingBodyType.getTailType():TailType.NONE))
						.wing(new Wing(stage.isWingFurry()?startingBodyType.getWingType():WingType.NONE))
						.build();
		
		// Apply fetish mdifiers:
		
		GameCharacter genericOwner = Main.game.getGenericAndrogynousNPC();
		
		//Ass:
		if(hasFetish(Fetish.FETISH_ANAL_GIVING)) {
			if(this.getAttributeValue(Attribute.CORRUPTION) >= CorruptionLevel.THREE_DIRTY.getMinimumValue()) {
				body.getAss().getAnus().getOrificeAnus().addOrificeModifier(genericOwner, OrificeModifier.RIBBED);
				body.getAss().getAnus().getOrificeAnus().addOrificeModifier(genericOwner, OrificeModifier.MUSCLE_CONTROL);
				body.getAss().getAnus().getOrificeAnus().addOrificeModifier(genericOwner, OrificeModifier.PUFFY);
			}
			if(this.getAttributeValue(Attribute.CORRUPTION) >= CorruptionLevel.FOUR_LUSTFUL.getMinimumValue()) {
				body.getAss().getAnus().getOrificeAnus().addOrificeModifier(genericOwner, OrificeModifier.TENTACLED);
			}
			
			body.getAss().setAssSize(genericOwner, AssSize.FIVE_HUGE.getValue());
			body.getAss().setAssSize(genericOwner, HipSize.FIVE_VERY_WIDE.getValue());
		}
		
		// Body:
		if(preferredGender.isFeminine()) {
			// Want feminine bodies to be smaller than them:
			body.setHeight(getHeightValue() - Util.random.nextInt(25));
			
		} else {
			// Want masculine bodies to be taller than them:
			body.setHeight(getHeightValue() + Util.random.nextInt(25));
		}
		
		//Breasts:
		if(Main.getProperties().multiBreasts==0) {
			body.getBreast().setRows(genericOwner, 1);
			
		} else if(Main.getProperties().multiBreasts==1) {
			if(stage != RaceStage.GREATER) {
				body.getBreast().setRows(genericOwner, 1);
			}
		}

		if(hasFetish(Fetish.FETISH_BREASTS_OTHERS) && preferredGender.isFeminine()) {
			body.getBreast().setSize(genericOwner, CupSize.DD.getMeasurement() + (Util.random.nextInt(5)));
		}
		
		// Face:
		if(hasFetish(Fetish.FETISH_ORAL_RECEIVING)) {
			body.getFace().getMouth().getOrificeMouth().addOrificeModifier(genericOwner, OrificeModifier.PUFFY);
			body.getFace().getMouth().setLipSize(genericOwner, LipSize.FOUR_HUGE.getValue());
			
			if(this.getAttributeValue(Attribute.CORRUPTION) >= CorruptionLevel.THREE_DIRTY.getMinimumValue()) {
				body.getFace().getMouth().getOrificeMouth().addOrificeModifier(genericOwner, OrificeModifier.RIBBED);
				body.getFace().getMouth().getOrificeMouth().addOrificeModifier(genericOwner, OrificeModifier.MUSCLE_CONTROL);
			}
			if(this.getAttributeValue(Attribute.CORRUPTION) >= CorruptionLevel.FOUR_LUSTFUL.getMinimumValue()) {
				body.getFace().getMouth().getOrificeMouth().addOrificeModifier(genericOwner, OrificeModifier.TENTACLED);
			}
		}
		
		// Hair:
		if(preferredGender.isFeminine()) {
			body.getHair().setLength(genericOwner, HairLength.THREE_SHOULDER_LENGTH.getMedianValue() + Util.random.nextInt(HairLength.SEVEN_TO_FLOOR.getMinimumValue() - HairLength.THREE_SHOULDER_LENGTH.getMedianValue()));
			
		} else {
			body.getHair().setLength(genericOwner, HairLength.ONE_VERY_SHORT.getMedianValue() + Util.random.nextInt(HairLength.THREE_SHOULDER_LENGTH.getMinimumValue() - HairLength.ONE_VERY_SHORT.getMedianValue()));
		}
		
		// Penis:
		if(body.getPenis().getType()!=PenisType.NONE) {
			if(preferredGender==Gender.F_P_TRAP && Math.random()>=0.1f) { // Most traps have a small cock:
				body.getPenis().setPenisSize(genericOwner, PenisSize.ONE_TINY.getMedianValue() + Util.random.nextInt(4));
				body.getPenis().getTesticle().setTesticleSize(genericOwner, TesticleSize.ONE_TINY.getValue());
				body.getPenis().getTesticle().setCumProduction(genericOwner, CumProduction.ONE_TRICKLE.getMedianValue());
			} else {
				body.getPenis().setPenisSize(genericOwner,body.getPenis().getSize().getMinimumValue() + Util.random.nextInt(body.getPenis().getSize().getMaximumValue() - body.getPenis().getSize().getMinimumValue()) +1);
			}
		}
		
		// Vagina:
		if(body.getVagina().getType()!=VaginaType.NONE) {
			if(this.getAttributeValue(Attribute.CORRUPTION) >= CorruptionLevel.THREE_DIRTY.getMinimumValue()) {
				body.getVagina().getOrificeVagina().addOrificeModifier(genericOwner, OrificeModifier.RIBBED);
				body.getVagina().getOrificeVagina().addOrificeModifier(genericOwner, OrificeModifier.MUSCLE_CONTROL);
			}
			if(this.getAttributeValue(Attribute.CORRUPTION) >= CorruptionLevel.FOUR_LUSTFUL.getMinimumValue()) {
				body.getVagina().getOrificeVagina().addOrificeModifier(genericOwner, OrificeModifier.TENTACLED);
			}
			
			body.getVagina().getOrificeVagina().setWetness(genericOwner, Wetness.THREE_WET.getValue() + Util.random.nextInt(4));
		}
		
		return body;
	}
	
	// Sex:
	
	public String getLostVirginityDescriptor() {
		return "";
	}
	
	public void endSex(boolean applyEffects) {
	}
	
	public Set<SexPosition> getSexPositionPreferences(){
		sexPositionPreferences.clear();
		
		// Doggy, kneeling, 69, wall back, wall front
		
		if(Sex.isPlayerDom()) { // These are irrelevant, as the player can always choose what to do if they're the dom:
			if(hasFetish(Fetish.FETISH_ORAL_GIVING) && canUseMouth()) {
				sexPositionPreferences.add(SexPosition.KNEELING_PARTNER_PERFORMING_ORAL);
				sexPositionPreferences.add(SexPosition.SIXTY_NINE_PLAYER_TOP);
			}
			
			if(this.hasFetish(Fetish.FETISH_ANAL_RECEIVING) && canUseAnus()) {
				sexPositionPreferences.add(SexPosition.DOGGY_PARTNER_ON_ALL_FOURS);
				sexPositionPreferences.add(SexPosition.FACING_WALL_PARTNER);
			}
			
			if(this.hasFetish(Fetish.FETISH_PREGNANCY) && canUseVagina()) {
				sexPositionPreferences.add(SexPosition.DOGGY_PARTNER_ON_ALL_FOURS);
				sexPositionPreferences.add(SexPosition.FACING_WALL_PARTNER);
				sexPositionPreferences.add(SexPosition.BACK_TO_WALL_PARTNER);
			}

			if(this.hasFetish(Fetish.FETISH_IMPREGNATION) && canUsePenis()) {
				sexPositionPreferences.add(SexPosition.BACK_TO_WALL_PARTNER);
			}
			
			if(getRace()==Race.DOG_MORPH || getRace()==Race.WOLF_MORPH) {
				sexPositionPreferences.add(SexPosition.DOGGY_PARTNER_ON_ALL_FOURS);
			}
			
		} else { // Taking into account partner and player body parts and accessibility:
			if(hasFetish(Fetish.FETISH_ORAL_RECEIVING) && playerCanUseMouth() && (canUsePenis() || canUseVagina())) {
				sexPositionPreferences.add(SexPosition.KNEELING_PLAYER_PERFORMING_ORAL);
			}
			
			if(hasFetish(Fetish.FETISH_ORAL_GIVING) && canUseMouth() && (playerCanUsePenis() || playerCanUseVagina())) {
				sexPositionPreferences.add(SexPosition.KNEELING_PARTNER_PERFORMING_ORAL);
				sexPositionPreferences.add(SexPosition.SIXTY_NINE_PARTNER_TOP);
			}
			
			if(hasFetish(Fetish.FETISH_ANAL_GIVING) && canUsePenis() && playerCanUseAnus()) {
				sexPositionPreferences.add(SexPosition.DOGGY_PLAYER_ON_ALL_FOURS);
				sexPositionPreferences.add(SexPosition.FACING_WALL_PLAYER);
			}
			
			if(hasFetish(Fetish.FETISH_ANAL_RECEIVING) && playerCanUsePenis() && canUseAnus()) {
				sexPositionPreferences.add(SexPosition.COWGIRL_PARTNER_TOP);
				sexPositionPreferences.add(SexPosition.DOGGY_PARTNER_AS_DOM_ON_ALL_FOURS);
			}
			
			if((hasFetish(Fetish.FETISH_IMPREGNATION) || hasFetish(Fetish.FETISH_SEEDER)) && canUsePenis() && playerCanUseVagina()) {
				sexPositionPreferences.add(SexPosition.DOGGY_PLAYER_ON_ALL_FOURS);
				sexPositionPreferences.add(SexPosition.FACING_WALL_PLAYER);
				sexPositionPreferences.add(SexPosition.BACK_TO_WALL_PLAYER);
			}
			
			if((hasFetish(Fetish.FETISH_PREGNANCY) || hasFetish(Fetish.FETISH_BROODMOTHER)) && playerCanUsePenis() && canUseVagina()) {
				sexPositionPreferences.add(SexPosition.BACK_TO_WALL_PLAYER);
				sexPositionPreferences.add(SexPosition.COWGIRL_PARTNER_TOP);
				sexPositionPreferences.add(SexPosition.DOGGY_PARTNER_AS_DOM_ON_ALL_FOURS);
			}
			
			if(sexPositionPreferences.isEmpty()) { // If no preferences found, add 'standard' positions
				sexPositionPreferences.add(SexPosition.BACK_TO_WALL_PLAYER);
				sexPositionPreferences.add(SexPosition.DOGGY_PLAYER_ON_ALL_FOURS);
				sexPositionPreferences.add(SexPosition.FACING_WALL_PLAYER);
				sexPositionPreferences.add(SexPosition.KNEELING_PLAYER_PERFORMING_ORAL);
				sexPositionPreferences.add(SexPosition.SIXTY_NINE_PARTNER_TOP);
				sexPositionPreferences.add(SexPosition.COWGIRL_PARTNER_TOP);
			}
			
		}
		
		return sexPositionPreferences;
	}
	
	public boolean isWantsToHaveSexWithPlayer() {
		if(hasStatusEffect(StatusEffect.WEATHER_STORM_VULNERABLE)) { // If they're vulnerable to arcane storms, they will always be eager during a storm:
			return true;
		}
		
		if(isSlave()) {
			if(this.getAffection(Main.game.getPlayer())<AffectionLevel.POSITIVE_ONE_FRIENDLY.getMinimumValue()) {
				return false;
			}
		}
		
		if(hasStatusEffect(StatusEffect.FETISH_PURE_VIRGIN)
				|| (getSexualOrientation()==SexualOrientation.ANDROPHILIC && Main.game.getPlayer().isFeminine())
				|| (getSexualOrientation()==SexualOrientation.GYNEPHILIC && !Main.game.getPlayer().isFeminine())
//				|| hasFetish(Fetish.FETISH_NON_CON)
				) {
			return false;
		}
		
		if(mother!=null && father!=null) {
			if(mother.isPlayer() || father.isPlayer()) {
				if (!hasFetish(Fetish.FETISH_INCEST)) {
					return false;
				}
			}
		}
		
		return true;
	}

	public SexPace getSexPaceSubPreference(){
		if(!isWantsToHaveSexWithPlayer()) {
			if(Main.game.isNonConEnabled()) {
				if(isSlave()) {
					if(this.getObedience()>=ObedienceLevel.POSITIVE_FIVE_SUBSERVIENT.getMinimumValue()) {
						return SexPace.SUB_EAGER;
						
					} else if(this.getObedience()>=ObedienceLevel.POSITIVE_TWO_OBEDIENT.getMinimumValue()) {
						return SexPace.SUB_NORMAL;
					}
				}
				
				if(mother!=null && father!=null) {
					if(mother.isPlayer() || father.isPlayer()) {
						if (getHistory() == History.PROSTITUTE) {
							if(Sex.isConsensual()) {
								return SexPace.SUB_NORMAL;
							}
						}
					}
				}
				
				return SexPace.SUB_RESISTING;
				
			} else {
				return SexPace.SUB_NORMAL;
				
			}
		}
		
		if(hasStatusEffect(StatusEffect.WEATHER_STORM_VULNERABLE)) { // If they're vulnerable to arcane storms, they will always be eager during a storm:
			return SexPace.SUB_EAGER;
		}
		
		if (hasFetish(Fetish.FETISH_SUBMISSIVE) // Subs like being sub I guess ^^
				|| (hasFetish(Fetish.FETISH_PREGNANCY) && Main.game.getPlayer().hasPenis() && hasVagina()) // Want to get pregnant
				|| (hasFetish(Fetish.FETISH_IMPREGNATION) && Main.game.getPlayer().hasVagina() && hasPenis()) // Want to impregnate player
				) {
			return SexPace.SUB_EAGER;
		}
		
		return SexPace.SUB_NORMAL;
	}
	
	public SexPace getSexPaceDomPreference(){
		
		if(hasStatusEffect(StatusEffect.FETISH_PURE_VIRGIN)
				|| (hasFetish(Fetish.FETISH_SUBMISSIVE) && !hasFetish(Fetish.FETISH_DOMINANT)) // Subs like being sub I guess ^^
				) {
			return SexPace.DOM_GENTLE;
		}
		
		if(hasFetish(Fetish.FETISH_SADIST)
				|| hasFetish(Fetish.FETISH_DOMINANT)
				) {
			return SexPace.DOM_ROUGH;
		}
		
		return SexPace.DOM_NORMAL;
	}
	
	private boolean canUseMouth() {
		return isAbleToAccessCoverableArea(CoverableArea.MOUTH, true);
	}
	private boolean canUsePenis() {
		return hasPenis() && isAbleToAccessCoverableArea(CoverableArea.PENIS, true);
	}
	private boolean canUseVagina() {
		return hasVagina() && isAbleToAccessCoverableArea(CoverableArea.VAGINA, true);
	}
	private boolean canUseAnus() {
		return hasVagina() && isAbleToAccessCoverableArea(CoverableArea.ANUS, true);
	}
	private boolean playerCanUseMouth() {
		return Main.game.getPlayer().isAbleToAccessCoverableArea(CoverableArea.MOUTH, true);
	}
	private boolean playerCanUsePenis() {
		return Main.game.getPlayer().hasPenis() && Main.game.getPlayer().isAbleToAccessCoverableArea(CoverableArea.PENIS, true);
	}
	private boolean playerCanUseVagina() {
		return Main.game.getPlayer().hasVagina() && Main.game.getPlayer().isAbleToAccessCoverableArea(CoverableArea.VAGINA, true);
	}
	private boolean playerCanUseAnus() {
		return Main.game.getPlayer().hasVagina() && Main.game.getPlayer().isAbleToAccessCoverableArea(CoverableArea.ANUS, true);
	}
	
	public boolean isReactedToPregnancy() {
		return reactedToPregnancy;
	}
	public void setReactedToPregnancy(boolean reactedToPregnancy) {
		this.reactedToPregnancy = reactedToPregnancy;
	}
	
	public boolean isReactedToPlayerPregnancy() {
		return reactedToPlayerPregnancy;
	}
	public void setReactedToPlayerPregnancy(boolean reactedToPlayerPregnancy) {
		this.reactedToPlayerPregnancy = reactedToPlayerPregnancy;
	}
	
	public boolean isPendingClothingDressing() {
		return pendingClothingDressing;
	}
	public void setPendingClothingDressing(boolean pendingClothingDressing) {
		this.pendingClothingDressing = pendingClothingDressing;
	}


	/**
	 * Returns a description of how this npc reacts to item usage.
	 * @param item
	 * @return
	 */
	public String getItemUseEffects(AbstractItem item, GameCharacter user, GameCharacter target){
		// Player is using an item:
		if(user.isPlayer()) {
			// Player uses item on themselves:
			if(target.isPlayer()) {
				return Main.game.getPlayer().useItem(item, target, false);
				
			// Player uses item on NPC:
			} else {
				return "<p>"
							+ "You try to give [npc.name] the "+item.getName()+", but [npc.she] refuses to take it. You put the "+item.getName()+" back in your inventory."
						+ "</p>";
			}
			
		// NPC is using an item:
		} else {
			return Sex.getPartner().useItem(item, target, false);
		}
	}
	
	private static StringBuilder infoScreenSB = new StringBuilder();
	
	public static String getCharacterInformationScreen(NPC character) {
		infoScreenSB.setLength(0);
		
		infoScreenSB.append(
				"<div class='inventory-container right'>"
					+ RenderingEngine.ENGINE.getInventoryEquippedPanel(character)
				+ "</div>"
				+ getCharacterInfoBox(character)
				+ "<h4>Background</h4>"
				+ "<p>"
					+ character.getDescription()
				+ "</p>"
				+ "</br>"
				+ "<h4>Relationships</h4>"
				+ "<p>"
					+ "[style.boldAffection(Affection:)]</br>"
					+ AffectionLevel.getDescription(character, Main.game.getPlayer(),
							AffectionLevel.getAffectionLevelFromValue(character.getAffection(Main.game.getPlayer())), true));
		
		for(Entry<GameCharacter, Float> entry : character.getAffectionMap().entrySet()) {
			if(!entry.getKey().isPlayer()) {
				infoScreenSB.append("</br>" + AffectionLevel.getDescription(character, entry.getKey(), AffectionLevel.getAffectionLevelFromValue(character.getAffection(entry.getKey())), true));
			}
		}
		
		infoScreenSB.append("</br></br>"
					+ "[style.boldObedience(Obedience:)]</br>"
					+ UtilText.parse(character,
							(character.isSlave()
								?"[npc.Name] [style.boldArcane(is a slave)], owned by "+(character.getOwner().isPlayer()?"you!":character.getOwner().getName("a")+".")
								:"[npc.Name] [style.boldGood(is not a slave)]."))
					+ "</br>"+ObedienceLevel.getDescription(character, ObedienceLevel.getObedienceLevelFromValue(character.getObedience()), true, true)
					+"</br></br>"
					+ "[style.boldArcane(Slaves owned:)]");
		
		if(character.getSlavesOwned().isEmpty()) {
			infoScreenSB.append("</br>[style.colourDisabled(None)]");
		} else {
			for(GameCharacter slave : character.getSlavesOwned()) {
				infoScreenSB.append(UtilText.parse(slave, "</br>[npc.Name]"));
			}
		}
		
		infoScreenSB.append("</p>"
				+ "</br>"
					+ "<h4>Appearance</h4>"
				+ "<p>"
					+ character.getBodyDescription()
				+ "</p>"
				+ getStats(character));
		
		return infoScreenSB.toString();
	}

	private static StringBuilder infoBoxSB = new StringBuilder();

	public static String getCharacterInfoBox(NPC character) {
		infoBoxSB.setLength(0);
		
		infoBoxSB.append("<div class='combat-display left' style='float:right;'>"

		// Display Name and level:
		+ "<div class='combat-inner-container'>"
				+ "<div class='combat-container name'>"
					+ "<div class='combat-container'>"
						+ "<p class='combatant-title name' style='color:" + Femininity.valueOf(character.getFemininityValue()).getColour().toWebHexString() + ";'>" 
							+ "<b>" + Util.capitaliseSentence(character.getName()) + "</b>"
						+ "</p>"
					+ "</div>"
					+ "<div class='combat-container'>"
						+ "<p class='combatant-title level'>"
							+ "<b>Level " + character.getLevel() +"</b>"
							+ "</br>"
							+(character.getRaceStage().getName()!=""
								?"<b style='color:"+character.getRaceStage().getColour().toWebHexString()+";'>" + Util.capitaliseSentence(character.getRaceStage().getName())+"</b> ":"")
							+ "<b style='color:"+character.getRace().getColour().toWebHexString()+";'>"
							+ (character.isFeminine()?Util.capitaliseSentence(character.getRace().getSingularFemaleName()):Util.capitaliseSentence(character.getRace().getSingularMaleName()))
							+ "</b>"
						+ "</p>"
					+ "</div>"
					+ "<div class='overlay no-pointer' id='COMBAT_OPPONENT_ATTRIBUTES'></div>" 
				+ "</div>"
				+ "</div>"

		// Attributes:
		+ "<div class='combat-inner-container'>"
			+ "<div class='combat-container attribute'>"
				+ "<div class='combat-resource-icon'>" + StrengthLevel.getStrengthLevelFromValue(character.getAttributeValue(Attribute.STRENGTH)).getRelatedStatusEffect().getSVGString(character) + "</div>"
				+ "<div class='combat-resource-number'>"
					+ "<b style='color:" + Attribute.STRENGTH.getColour().toWebHexString() + ";'>" + (int) character.getAttributeValue(Attribute.STRENGTH) + "</b>"
				+ "</div>"
				+ "<div class='overlay no-pointer' id='COMBAT_OPPONENT_" + Attribute.STRENGTH + "'></div>"
			+ "</div>"

			+ "<div class='combat-container attribute'>"
				+ "<div class='combat-resource-icon'>" + IntelligenceLevel.getIntelligenceLevelFromValue(character.getAttributeValue(Attribute.INTELLIGENCE)).getRelatedStatusEffect().getSVGString(character) + "</div>"
				+ "<div class='combat-resource-number'>"
				+ "<b style='color:" + Attribute.INTELLIGENCE.getColour().toWebHexString() + ";'>" + (int) character.getAttributeValue(Attribute.INTELLIGENCE) + "</b>"
				+ "</div>"
				+ "<div class='overlay no-pointer' id='COMBAT_OPPONENT_" + Attribute.INTELLIGENCE + "'></div>"
			+ "</div>"

			+ "<div class='combat-container attribute'>"
				+ "<div class='combat-resource-icon'>" + FitnessLevel.getFitnessLevelFromValue(character.getAttributeValue(Attribute.FITNESS)).getRelatedStatusEffect().getSVGString(character) + "</div>"
				+ "<div class='combat-resource-number'>"
				+ "<b style='color:" + Attribute.FITNESS.getColour().toWebHexString() + ";'>" + (int) character.getAttributeValue(Attribute.FITNESS) + "</b>"
				+ "</div>"
				+ "<div class='overlay no-pointer' id='COMBAT_OPPONENT_" + Attribute.FITNESS + "'></div>"
			+ "</div>"

			+ "<div class='combat-container attribute'>"
				+ "<div class='combat-resource-icon'>" + CorruptionLevel.getCorruptionLevelFromValue(character.getAttributeValue(Attribute.CORRUPTION)).getRelatedStatusEffect().getSVGString(character) + "</div>"
				+ "<div class='combat-resource-number'>"
				+ "<b style='color:" + Attribute.CORRUPTION.getColour().toWebHexString() + ";'>" + (int) character.getAttributeValue(Attribute.CORRUPTION) + "</b>"
				+ "</div>"
				+ "<div class='overlay no-pointer' id='COMBAT_OPPONENT_" + Attribute.CORRUPTION + "'></div>"
			+ "</div>"
		+ "</div>"

		// Display health, willpower and stamina:
		+ "<div class='combat-inner-container'>"

				+ "<div class='combat-resource'>" + "<div class='combat-resource-icon'>" + Attribute.HEALTH_MAXIMUM.getSVGString() + "</div>" + "<div class='combat-resource-bar'>" + "<div style='height:10px; width:"
				+ (int) ((character.getHealth() / character.getAttributeValue(Attribute.HEALTH_MAXIMUM)) * 100f) + "%;" + "background:" + Colour.ATTRIBUTE_HEALTH.toWebHexString() + "; border-radius: 2px;'></div>" + "</div>"
				+ "<div class='combat-resource-number'>"
				+ (int) Math.ceil(character.getHealth()) + "</div>" + "<div class='overlay no-pointer' id='COMBAT_OPPONENT_" + Attribute.HEALTH_MAXIMUM + "'></div>" + "</div>"

				+ "<div class='combat-resource'>" + "<div class='combat-resource-icon'>" + Attribute.MANA_MAXIMUM.getSVGString() + "</div>" + "<div class='combat-resource-bar'>" + "<div style='height:10px; width:"
				+ (int) ((character.getMana() / character.getAttributeValue(Attribute.MANA_MAXIMUM)) * 100f) + "%;" + "background:" + Colour.ATTRIBUTE_MANA.toWebHexString() + "; border-radius: 2px;'></div>" + "</div>"
				+ "<div class='combat-resource-number'>" + (int) Math.ceil(character.getMana()) + "</div>" + "<div class='overlay no-pointer' id='COMBAT_OPPONENT_" + Attribute.MANA_MAXIMUM + "'></div>" + "</div>"

				+ "<div class='combat-resource'>" + "<div class='combat-resource-icon'>" + Attribute.STAMINA_MAXIMUM.getSVGString() + "</div>" + "<div class='combat-resource-bar'>" + "<div style='height:10px; width:"
				+ (int) ((character.getStamina() / character.getAttributeValue(Attribute.STAMINA_MAXIMUM)) * 100f) + "%;" + "background:" + Colour.ATTRIBUTE_FITNESS.toWebHexString() + "; border-radius: 2px;'></div>" + "</div>"
				+ "<div class='combat-resource-number'>"
				+ (int) Math.ceil(character.getStamina()) + "</div>" + "<div class='overlay no-pointer' id='COMBAT_OPPONENT_" + Attribute.STAMINA_MAXIMUM + "'></div>" + "</div>"

				+ "</div>"

		// Display status effects:
		+ "<div class='combat-inner-container status-effects'>");
		
		for (Perk p : character.getPerks()) {
			infoBoxSB.append("<div class='combat-status-effect'>" + p.getSVGString() + "<div class='overlay no-pointer' id='PERK_COMBAT_" + p + "'></div>" + "</div>");
		}
		for (Fetish f : character.getFetishes()) {
			infoBoxSB.append("<div class='combat-status-effect'>" + f.getSVGString() + "<div class='overlay no-pointer' id='FETISH_COMBAT_" + f + "'></div>" + "</div>");
		}
		for (StatusEffect se : character.getStatusEffects()) {
			if (se.renderInEffectsPanel()) {
				if (se.isCombatEffect()) {
					infoBoxSB.append("<div class='combat-status-effect" + (!se.isBeneficial() ? " negativeCombat" : " positiveCombat") + "'>"
								+ se.getSVGString(character) + "<div class='overlay no-pointer' id='SE_COMBAT_" + se + "'></div>" + "</div>");
				} else {
					infoBoxSB.append(
							"<div class='combat-status-effect'>" + se.getSVGString(character) + "<div class='overlay no-pointer' id='SE_COMBAT_" + se + "'></div>" + "</div>");
				}
			}
		}
		for (SpecialAttack sa : character.getSpecialAttacks()) {
			infoBoxSB.append(
					"<div class='combat-status-effect'>" + sa.getSVGString() + "<div class='overlay no-pointer' id='SA_COMBAT_" + sa + "'></div>" + "</div>");
		}
		if (character.getMainWeapon() != null) {
			for (Spell s : character.getMainWeapon().getSpells()) {
				infoBoxSB
						.append("<div class='combat-status-effect'>" + s.getSVGString() + "<div class='overlay' id='SPELL_MAIN_COMBAT_" + s + "'></div>" + "</div>");
			}
		}
		if (character.getOffhandWeapon() != null) {
			for (Spell s : character.getOffhandWeapon().getSpells()) {
				infoBoxSB
						.append("<div class='combat-status-effect'>" + s.getSVGString() + "<div class='overlay' id='SPELL_OFFHAND_COMBAT_" + s + "'></div>" + "</div>");
			}
		}
		
		infoBoxSB.append("</div></div>");
			
		return infoBoxSB.toString();
	}
	
	public static String getStats(NPC character) {
		return "<h4 style='text-align:center;'>Stats</h4>"
				+"<table align='center'>"

				+ "<tr style='height:8px; color:"+character.getGender().getColour().toWebHexString()+";'><th>Core</th></tr>"
				+ statRow("Femininity", String.valueOf(character.getFemininityValue()))
				+ statRow("Height (cm)", String.valueOf(character.getHeightValue()))
				+ statRow("Hair length (cm)", String.valueOf(Util.conversionInchesToCentimetres(character.getHairRawLengthValue())))
				+ "<tr style='height:8px;'></tr>"

				+ "<tr style='height:8px; color:"+Colour.TRANSFORMATION_SEXUAL.toWebHexString()+";'><th>Breasts</th></tr>"
				+ statRow("Cup size", character.getBreastRawSizeValue() == 0 ? "N/A" : Util.capitaliseSentence(character.getBreastSize().getCupSizeName()))
				+ (character.getPlayerKnowsAreasMap().get(CoverableArea.NIPPLES)
					?statRow("Milk production (mL)", String.valueOf(character.getBreastRawLactationValue()))
						+ statRow("Capacity (inches)", String.valueOf(character.getNippleRawCapacityValue()))
						+ statRow("Elasticity", String.valueOf(character.getNippleElasticity().getValue()) + " ("+Util.capitaliseSentence(character.getNippleElasticity().getDescriptor())+")")
					:statRow("Milk production (mL)", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Capacity (inches)","<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Elasticity", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>"))
				+ "<tr style='height:8px;'></tr>"

				+ "<tr style='height:8px; color:"+Colour.TRANSFORMATION_SEXUAL.toWebHexString()+";'><th>Penis</th></tr>"
				+ (character.getPlayerKnowsAreasMap().get(CoverableArea.PENIS)
					?statRow("Length (inches)", character.getPenisType() == PenisType.NONE ? "N/A" : String.valueOf(character.getPenisRawSizeValue()))
						+ statRow("Ball size", character.getPenisType() == PenisType.NONE ? "N/A" : Util.capitaliseSentence(character.getTesticleSize().getDescriptor()))
						+ statRow("Cum production (mL)", character.getPenisType() == PenisType.NONE ? "N/A" : String.valueOf(character.getPenisRawCumProductionValue()))
					:statRow("Length (inches)", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Ball size", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Cum production (mL)", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>"))
				+ "<tr style='height:8px;'></tr>"

				+ "<tr style='height:8px; color:"+Colour.TRANSFORMATION_SEXUAL.toWebHexString()+";'><th>Vagina</th></tr>"
				+ (character.getPlayerKnowsAreasMap().get(CoverableArea.VAGINA)
					?statRow("Capacity (inches)", character.getVaginaType() == VaginaType.NONE ? "N/A" : String.valueOf(character.getVaginaRawCapacityValue()))
						+ statRow("Elasticity", String.valueOf(character.getVaginaElasticity().getValue()) + " ("+Util.capitaliseSentence(character.getVaginaElasticity().getDescriptor())+")")
						+ statRow("Wetness", character.getVaginaType() == VaginaType.NONE ? "N/A" : String.valueOf(character.getVaginaWetness().getValue()) +" ("+Util.capitaliseSentence(character.getVaginaWetness().getDescriptor())+")")
						+ statRow("Clit size (inches)", character.getVaginaType() == VaginaType.NONE ? "N/A" : String.valueOf(character.getVaginaRawClitorisSizeValue()))
					:statRow("Capacity (inches)", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Elasticity", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Wetness", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Clit size (inches)", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>"))
				+ "<tr style='height:8px;'></tr>"

				+ "<tr style='height:8px; color:"+Colour.TRANSFORMATION_SEXUAL.toWebHexString()+";'><th>Anus</th></tr>"
				+ (character.getPlayerKnowsAreasMap().get(CoverableArea.ANUS)
					?statRow("Capacity (inches)", String.valueOf(character.getAssRawCapacityValue()))
						+ statRow("Elasticity", String.valueOf(character.getAssElasticity().getValue()) + " ("+Util.capitaliseSentence(character.getAssElasticity().getDescriptor())+")")
						+ statRow("Wetness", String.valueOf(character.getAssWetness().getValue()) +" ("+Util.capitaliseSentence(character.getAssWetness().getDescriptor())+")")
					:statRow("Capacity (inches)", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Elasticity", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>")
						+ statRow("Wetness", "<span style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>Undiscovered</span>"))
				+ "</table>";
	}
	
	private static String statRow(String title, String value) {
		return "<tr>"
					+ "<td style='min-width:100px;'>"
						+ "<b>"+title+"</b>"
					+ "</td>"
					+ "<td style='min-width:100px;'>"
						+ "<b>"+value+"</b>"
					+ "</td>"
				+ "</tr>";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ****************** Sex & Dirty talk: ***************************
	
	public String getCondomEquipEffects(GameCharacter equipper, GameCharacter target, boolean rough) {
		if(Main.game.isInSex() && !target.isPlayer()) {
			if(Sex.isPlayerDom() ||Sex.isConsensual()) {
				return "<p>"
						+ "Holding out a condom to [npc.name], you force [npc.herHim] to take it and put it on."
						+ " Quickly ripping it out of its little foil wrapper, [npc.she] rolls it down the length of [npc.her] [npc.cock+] as [npc.she] whines at you,"
						+ " [npc.speech(Do I really have to? It feels so much better without one...)]"
						+ "</p>";
			} else {
				return "<p>"
						+ "Holding out a condom to [npc.name], you let out a sigh of relief as [npc.she] reluctantly takes it."
						+ " Quickly ripping it out of its little foil wrapper, [npc.she] rolls it down the length of [npc.her] [npc.cock+] as [npc.she] growls at you,"
						+ " [npc.speech(You'd better be glad that I'm in a good mood!)]"
						+ "</p>";
			}
		}
		return AbstractClothingType.getEquipDescriptions(target, equipper, rough,
				"You tear open the packet and roll the condom down the length of your [pc.penis].",
				"You tear open the packet and roll the condom down the length of [npc.name]'s [npc.penis].",
				"You tear open the packet and forcefully roll the condom down the length [npc.name]'s [npc.penis].",
				"[npc.Name] tears open the packet and rolls the condom down the length of [npc.her] [npc.penis].",
				"[npc.Name] tears open the packet and rolls the condom down the length of your [pc.penis].",
				"[npc.Name] tears open the packet and forcefully rolls the condom down the length of your [pc.penis].");
	}
	
	/**
	 * @return A <b>formatted</b> piece of NPC speech, reacting to any current penetration.
	 */
	public String getDirtyTalk(boolean isPlayerDom) {
		if(!Main.game.isInSex()) {
			return "";
		
		} else {
			List<String> speech = new ArrayList<>(), speechSelf = new ArrayList<>();
			String s = "";
			
			// Taking vaginal:
			s = getDirtyTalkVaginaPenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Taking anal:
			s = getDirtyTalkAssPenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Taking something in their mouth:
			s = getDirtyTalkMouthPenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Taking nipple penetration:
			s = getDirtyTalkNipplePenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			
			// Giving vaginal:
			s = getDirtyTalkPlayerVaginaPenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Giving anal:
			s = getDirtyTalkPlayerAssPenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Putting something into the player's mouth:
			s = getDirtyTalkPlayerMouthPenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Giving nipple penetration:
			s = getDirtyTalkPlayerNipplePenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			
			// Choose a random line to say:
			if(!speech.isEmpty()){
				s = speech.get(Util.random.nextInt(speech.size())); // Prefer non-self penetrative speech.
				
			} else if(!speechSelf.isEmpty()){
				s = speechSelf.get(Util.random.nextInt(speechSelf.size()));
				
			} else {
				s = getDirtyTalkNoPenetration(isPlayerDom);
			}
			
			return UtilText.parseSpeech(s, this);
		}
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to no ongoing penetration.
	 */
	public String getDirtyTalkNoPenetration(boolean isPlayerDom){
		switch(Sex.getSexPacePartner()) {
			case DOM_GENTLE:
				return UtilText.returnStringAtRandom(
						"I'll be gentle, don't worry!",
						"You're going to be a good [pc.girl] now, aren't you?",
						"Let's have some fun!",
						"You're going to love this!");
			case DOM_NORMAL:
				return UtilText.returnStringAtRandom(
						"This is going to be good!",
						"How best to use you, I wonder...",
						"You're going to be a good [pc.girl]!",
						"Ready for some fun?");
			case DOM_ROUGH:
				return UtilText.returnStringAtRandom(
						"You ready to get fucked, slut?",
						"I'm going to fuck you senseless!",
						"You're my bitch now, understand?!",
						"I'm going to use you however I want, you fucking slut!");
			case SUB_EAGER:
				return UtilText.returnStringAtRandom(
						"Come on, fuck me already! Please!",
						"Fuck me! Please!",
						"What are you waiting for?! Come on, fuck me!",
						"I'm so horny! Please, fuck me!");
			case SUB_NORMAL:
				return UtilText.returnStringAtRandom(
						"I'll be a good [npc.girl]!",
						"I'll do whatever you want!",
						"Let's get started!",
						"Let's have some fun!");
			case SUB_RESISTING:
				return UtilText.returnStringAtRandom(
						"Go away! Leave me alone!",
						"Stop it! Just go away!",
						"Please stop! Don't do this!");
			default:
				return UtilText.returnStringAtRandom(
						"This is going to be good!",
						"Time for some fun!",
						"Let's get started!",
						"Let's have some fun!");
		}
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to having their vagina used. Returns null if no vagina or penetration found.
	 */
	public String getDirtyTalkVaginaPenetrated(boolean isPlayerDom){
		
		if(getVaginaType()!=VaginaType.NONE) {
			if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER) != null) {
				switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER)) {
					case FINGER_PLAYER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"That's right, be a good [pc.girl] now and push your [pc.fingers] in deeper!",
										"Good [pc.girl]! Keep those [pc.fingers] of yours busy!",
										"What a good [pc.girl]! My pussy loves the feeling of your [pc.fingers]!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"That's right, push your [pc.fingers] in deep!",
										"Good [pc.girl]! Get those [pc.fingers] in deep!",
										"Keep going! Curl your [pc.fingers] up a bit!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"Come on slut, you can get your [pc.fingers] in deeper than that!",
										"Keep it up bitch! Get those [pc.fingers] in deep!",
										"Keep going slut! Curl your [pc.fingers] up and put in a little more effort!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Keep fingering me!",
										"Keep going! My pussy loves your attention!",
										"Oh yes! I love being fingered!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Keep fingering me!",
										"Keep going! I love this!",
										"Oh yes!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get your [pc.fingers] out of me! Stop! Please!",
										"Stop fingering me! Please, no more!",
										"Stop it! Stop! Please!");
							default:
								return(UtilText.returnStringAtRandom(
										"Fuck!",
										"Yeah!",
										"Oh yeah!"));
						}
					case PENIS_PLAYER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"My pussy loves your [pc.cock]!",
										"Good [pc.girl]! Keep sliding that delicious cock of yours in and out of me!",
										"What a good [pc.girl]! Enjoy my pussy as your reward now!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"You like feeling my pussy gripping down on your cock?!",
										"Good [pc.girl]! Push your [pc.cock] in deep!",
										"Keep going! Get that [pc.cock] in deep like a good [pc.girl]!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, you're my little fuck toy now!",
										"Come on bitch! You can get your worthless [pc.cock] in deeper than that!",
										"Fucking slut, put some more effort in! My pussy deserves better than your worthless [pc.cock]!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me! Fuck me harder! Don't stop!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Fuck me! I love your [pc.cock]!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get out of me! Stop! Please!",
										"Please, no more! Take your cock out!",
										"Get out of me! Stop! Please!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TAIL_PLAYER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"My pussy loves your [pc.tail]! Keep going!",
										"Good [pc.girl]! Keep fucking me with that [pc.tail] of yours!",
										"What a good [pc.girl]! Enjoy my pussy as your reward now!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Oh yes! Your [pc.tail] feels so good!",
										"Good [pc.girl]! Push your [pc.tail] in deep!",
										"Keep going! Get that [pc.tail] in deep like a good [pc.girl]!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, get that [pc.tail] in deep like a good little fuck toy!",
										"Come on bitch! You can get your [pc.tail] in deeper than that!",
										"Fucking bitch, put some more effort in! My pussy deserves better than some slut's [pc.tail]!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me! Fuck me harder! Don't stop!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Fuck me! I love your [pc.tail]! Get it deeper!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get out of me! Stop! Please!",
										"Please, no more! Take your tail out!",
										"Get out of me! Stop! Please!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TONGUE_PLAYER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"That's right, keep eating me out like a good [pc.girl]!",
										"Good [pc.girl]! Keep that [pc.tongue] of yours busy!",
										"What a good [pc.girl]! You love the taste of my pussy, don't you?!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Oh yes! Get that [pc.tongue] in deep!",
										"Good [pc.girl]! Get that [pc.tongue] of yours in deep!",
										"Keep going! My pussy loves your [pc.tongue]!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, keep eating me out like the worthless little fuck toy you are!",
										"Come on bitch! Get that [pc.tongue] of yours in deeper!",
										"Fucking bitch, put some more effort in! You know how lucky you are, being allowed to taste my pussy like this?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! I love your [pc.tongue]! Don't stop!",
										"Don't stop! Deeper! Eat me out! Yes, yes, yes!",
										"Oh yes! Taste my pussy! I love your [pc.tongue]! Get it deeper!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Don't stop!",
										"Don't stop! I love your [pc.tongue]!",
										"Oh yes! Eat me out!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get out of me! Stop! Please!",
										"Please, no more! Take your tongue out!",
										"Get out of me! Stop! Please!");
							default:
								return UtilText.returnStringAtRandom(
										"Yes! Get that tongue deeper!",
										"Oh yeah! Keep going!",
										"Deeper! Don't stop!");
						}
					default:// Self penetration:
						switch(Sex.getSexPacePartner()) {
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Go away! Leave me alone!",
										"Stop it! Just go away!",
										"Please stop! Don't do this!");
							default:
								return(UtilText.returnStringAtRandom(
										"Fuck!",
										"Yeah!",
										"Oh yeah!"));
						}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to having their asshole used. Returns null if no penetration found.
	 */
	public String getDirtyTalkAssPenetrated(boolean isPlayerDom){
		
		if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER)) {
				case FINGER_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, be a good [pc.girl] now and push your [pc.fingers] in deeper!",
									"Good [pc.girl]! Keep those [pc.fingers] of yours busy!",
									"What a good [pc.girl]! Keep fingering my ass!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"That's right, push your [pc.fingers] in deep!",
									"Good [pc.girl]! Get those [pc.fingers] in deep!",
									"Keep going! My ass loves the attention!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on slut, you can get your [pc.fingers] in deeper than that!",
									"Keep it up bitch! Get those [pc.fingers] in deep!",
									"Keep going slut! Get your [pc.fingers] in deep and put in a little more effort!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep fingering my ass! Don't stop!",
									"Keep going! My ass loves the attention!",
									"Oh yes! My ass loves being fingered!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Keep fingering my ass!",
									"Keep going! I love this!",
									"Oh yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop fingering my ass! Stop! Please!",
									"Please, no more! Take your fingers out of my ass!",
									"Get out of my ass! Stop! Please!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My ass loves your [pc.cock]!",
									"Good [pc.girl]! Keep sliding that delicious cock of yours in and out of my ass!",
									"What a good [pc.girl]! Enjoy my ass as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You like feeling my slutty little asshole gripping down on your cock?!",
									"Good [pc.girl]! Push your [pc.cock] in deep!",
									"Keep going! Get that [pc.cock] in deep like a good [pc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, you're my little fuck toy now!",
									"Come on bitch! You can get your worthless [pc.cock] in deeper than that!",
									"Fucking slut, put some more effort in! My ass deserves better than your worthless [pc.cock]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me! Fuck me harder! Don't stop!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Fuck me! I love your [pc.cock]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your cock out of my ass!",
									"Get out of my ass! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My ass loves your [pc.tail]! Keep going!",
									"Good [pc.girl]! Keep fucking my ass with that [pc.tail] of yours!",
									"What a good [pc.girl]! Enjoy my ass as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Your [pc.tail] feels so good!",
									"Good [pc.girl]! Push your [pc.tail] in deep!",
									"Keep going! Get that [pc.tail] in deep like a good [pc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, get that [pc.tail] in deep like a good little fuck toy!",
									"Come on bitch! You can get your [pc.tail] in deeper than that!",
									"Fucking bitch, put some more effort in! My ass deserves better than some slut's [pc.tail]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me! Fuck me harder! Don't stop!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Fuck me! I love your [pc.tail]! Get it deeper!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tail out of my ass!",
									"Get out of my ass! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, keep that rimjob going like a good [pc.girl]!",
									"Good [pc.girl]! Keep that [pc.tongue] of yours busy in my ass!",
									"What a good [pc.girl]! You love the taste of my ass, don't you?!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Get that [pc.tongue] in deep!",
									"Good [pc.girl]! Get that [pc.tongue] of yours in deep!",
									"Keep going! My ass loves your [pc.tongue]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, keep that rimjob going like the worthless little fuck toy you are!",
									"Come on bitch! Get that [pc.tongue] of yours deeper into my ass!",
									"Fucking bitch, put some more effort in! You know how lucky you are, being allowed to lick my ass like this?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love your [pc.tongue]! Don't stop!",
									"Don't stop! Deeper! Get your [pc.tongue] into my ass! Yes, yes, yes!",
									"Oh yes! Taste my ass! I love your [pc.tongue]! Get it deeper!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Don't stop!",
									"Don't stop! I love your [pc.tongue]!",
									"Oh yes! Taste my ass!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tongue out of my ass!",
									"Get your tongue out of my ass! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePartner()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
			}
		}

		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to having their mouth used. Returns null if no penetration found.
	 */
	public String getDirtyTalkMouthPenetrated(boolean isPlayerDom){

		if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER)) {
				case FINGER_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Your fingers taste good!",
									"Good [pc.girl]! Your [pc.fingers] taste so good!",
									"What a good [pc.girl]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Your fingers taste good!",
									"Good [pc.girl]! Your [pc.fingers] taste so good!",
									"What a good [pc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Fucking slut, let's get your [pc.fingers] all nice and wet now!",
									"That's right bitch! Let's get your [pc.fingers] nice and wet!",
									"Hold still slut! I need your [pc.fingers] all nice and lubed up!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"I love the taste of your [pc.fingers]! Don't stop!",
									"Keep going! I love sucking on your [pc.fingers]!",
									"Oh yes! I love the taste of your [pc.fingers]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love the taste of your [pc.fingers]!",
									"I love sucking on your [pc.fingers]!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your fingers out of my mouth!",
									"Get out of my mouth! Stop! Please!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"I love your [pc.cock]!",
									"Good [pc.girl]! Your delicious cock deserves this nice reward!",
									"What a good [pc.girl]! I hope you're enjoying your reward!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Your cock tastes so good!",
									"I love sucking your [pc.cock]!",
									"Oh yes! Your [pc.cock] tastes so good!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Hold still slut, be a good little fuck toy and just be thankful that I love sucking cock!",
									"Stay still bitch! You'd better be happy that your worthless [pc.cock] is the only thing for me to suck right now!",
									"Fucking slut, hold still! I need to practice my oral skills on your worthless [pc.cock]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Oh yes! I love your [pc.cock]! I need it! Use my throat!",
									"Don't stop! Harder! Fuck my throat! Yes, yes, yes!",
									"Oh yes! I love your [pc.cock]! You taste so good!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love your [pc.cock]! Use my throat!",
									"Fuck my throat! Oh yes!",
									"I love your [pc.cock]! You taste so good!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your cock out of my mouth!",
									"Get your cock away from me! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"I love sucking cock!",
									"Oh yeah! I love your cock!",
									"Don't stop!");
					}
				case TAIL_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"I love sucking your [pc.tail]!",
									"Good [pc.girl]! Get this delicious [pc.tail] of yours deep down my throat!",
									"What a good [pc.girl]! I hope you're enjoying your reward!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love sucking your [pc.tail]!",
									"Good [pc.girl]! Get this delicious [pc.tail] of yours deep down my throat!",
									"What a good [pc.girl]! I hope you're enjoying your reward!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Hold still slut, be a good little fuck toy and just be thankful that I decided to practice oral on your [pc.tail]!",
									"Stay still bitch! You'd better be happy that I decided to practice my cock-sucking on your [pc.tail]!",
									"Fucking slut, hold still! I need to practice my oral skills on your [pc.tail]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Oh yes! I love your [pc.tail]! I need it! Use my throat!",
									"Don't stop! Harder! Fuck my throat! Yes, yes, yes!",
									"Oh yes! I love your [pc.tail]! You taste so good!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love your [pc.tail]! Use my throat!",
									"Fuck my throat! Oh yes!",
									"I love your [pc.tail]! You taste so good!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tail out of my mouth!",
									"Get your tail away from me! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"I love sucking your [pc.tail]!",
									"Oh yeah! I love your [pc.tail]!",
									"Don't stop!");
					}
				case TONGUE_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Yes! Good [pc.girl]!",
									"Good [pc.girl]! I love your [pc.lips]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Good [pc.girl]!",
									"Good [pc.girl]! I love your [pc.lips]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Yes! Good bitch!",
									"Good slut! I love your [pc.lips]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Good [pc.girl]!",
									"Good [pc.girl]! I love your [pc.lips]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Good [pc.girl]!",
									"Good [pc.girl]! I love your [pc.lips]!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Stop kissing me like this!",
									"Get away from me! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Good [pc.girl]!",
									"Good [pc.girl]! I love your [pc.lips]!",
									"Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePartner()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
			}
		}

		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to having their nipples used. Returns null if no penetration found.
	 */
	public String getDirtyTalkNipplePenetrated(boolean isPlayerDom){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER)) {
				case FINGER_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, be a good [pc.girl] now and push your [pc.fingers] deeper into my nipple!",
									"Good [pc.girl]! Keep those [pc.fingers] of yours busy in my breast!",
									"What a good [pc.girl]! My nipples love the feeling of your [pc.fingers]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"That's right, push your [pc.fingers] deep into my breast!",
									"Good [pc.girl]! Get those [pc.fingers] deep into my nipple!",
									"Keep going! Curl your [pc.fingers] up a bit!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on slut, you can get your [pc.fingers] deeper into my breast than that!",
									"Keep it up bitch! Get those [pc.fingers] deep into my nipple!",
									"Keep going slut! Curl your [pc.fingers] up and put in a little more effort!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep fingering my nipple!",
									"Keep going! My nipples love your attention!",
									"Oh yes! I love getting my nipples fingered!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Keep fingering my nipple!",
									"Keep going! I love this!",
									"Oh yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your fingers out of my nipple!",
									"Get out of my nipple! Stop! Please!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My nipples love your [pc.cock]!",
									"Good [pc.girl]! Keep sliding that delicious cock of yours in and out of my tits!",
									"What a good [pc.girl]! Enjoy my tits as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You like feeling my nipple gripping down on your cock?!",
									"Good [pc.girl]! Push your [pc.cock] deep into my breast!",
									"Keep going! Get that [pc.cock] in deep like a good [pc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, my tits could use some attention from a little fuck toy like you!",
									"Come on bitch! You can get your worthless [pc.cock] deeper into my tits than that!",
									"Fucking slut, put some more effort in! My breasts deserve better than your worthless [pc.cock]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits! Fuck them harder! Don't stop!",
									"Don't stop! Harder! Fuck my nipples! Yes, yes, yes!",
									"Oh yes! Fuck my tits! I love your [pc.cock]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits!",
									"Don't stop! Fuck my nipples!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your cock out of my breast!",
									"Get out of my nipple! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My tits love your [pc.tail]! Keep going!",
									"Good [pc.girl]! Keep fucking my nipples with that [pc.tail] of yours!",
									"What a good [pc.girl]! Enjoy my tits as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Your [pc.tail] feels so good!",
									"Good [pc.girl]! Push your [pc.tail] deep into my breast!",
									"Keep going! Get that [pc.tail] deep into my tits like a good [pc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, get that [pc.tail] deep into my nipple like a good little fuck toy!",
									"Come on bitch! You can get your [pc.tail] deeper into my tits than that!",
									"Fucking bitch, put some more effort in! My breasts deserve better than some slut's [pc.tail]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits! Fuck them harder! Don't stop!",
									"Don't stop! Harder! Fuck my nipples! Yes, yes, yes!",
									"Oh yes! Fuck my tits! I love your [pc.tail]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits!",
									"Don't stop! Fuck my nipples!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tail out of my nipple!",
									"Get out of my nipple! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PLAYER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, keep sucking on my nipples like a good [pc.girl]!",
									"Good [pc.girl]! Keep that [pc.tongue] of yours busy!",
									"What a good [pc.girl]! You love my tits, don't you?!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Keep sucking on my nipples!",
									"Good [pc.girl]! Get that [pc.tongue] of yours deep into my nipples!",
									"Keep going! My tits love the feel of your [pc.tongue]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, keep sucking on my tits like the worthless little fuck toy you are!",
									"Come on bitch! Get that [pc.tongue] of yours deeper into my nipples!",
									"Fucking bitch, put some more effort in! You know how lucky you are, being allowed to suck on ym tits like this?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love the feeling of your lips on my tits! Don't stop!",
									"Don't stop! Suck on my tits! Yes, yes, yes!",
									"Oh yes! Lick my nipples! I love your [pc.tongue]! Get it deeper!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Don't stop!",
									"Don't stop! I love your [pc.tongue]!",
									"Oh yes! Suck on my tits!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tongue out of my nipple!",
									"Leave me alone! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePartner()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
			}
		}
		
		return null;
	}
	
	// Dirty talk related to penetrating areas:
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to the player having their vagina used. Returns null if no vagina or penetration found.
	 */
	public String getDirtyTalkPlayerVaginaPenetrated(boolean isPlayerDom){
		if(Main.game.getPlayer().getVaginaType()!=VaginaType.NONE) {
			if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER) != null) {
				switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER)) {
					case FINGER_PARTNER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Good [pc.girl], you love feeling my [npc.fingers] deep in your pussy, don't you?",
										"I love fingering cute little things like you!",
										"What a good [pc.girl]! Your pussy loves the feeling of my [npc.fingers], doesn't it?");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"You love the feeling of my [npc.fingers] deep in your pussy, don't you?!",
										"I love fingering cute [pc.girl]s like you!",
										"You like it when I curl my [npc.fingers] up inside you, like <i>this</i>?!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"What a dirty slut! I can feel your horny pussy clenching down on my [npc.fingers]!",
										"You love this, don't you bitch?! Feeling my [npc.fingers] pushing deep into your slutty cunt!",
										"That's right slut! You love having my [npc.fingers] stuffed deep in your slutty pussy!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Let me get my fingers deep inside your little pussy!",
										"I love giving your pussy the attention it deserves!",
										"I love fingering you!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"I love fingering your pussy!",
										"I love giving your pussy the attention it deserves!",
										"I love fingering you!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please let me stop!",
										"Let me go! I don't want to do this!",
										"Please! Stop! I don't want this!");
							default:
								return(UtilText.returnStringAtRandom(
										"Fuck!",
										"Yeah!",
										"Oh yeah!"));
						}
					case PENIS_PARTNER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Good [pc.girl]! Feel my [npc.cock] slide deep into your little pussy!",
										"That's right, be a good [pc.girl] and moan for me! Feel my [npc.cock] sliding deep into your cute little cunt!",
										"Your cute little cunt feels so good squeezing down around my [npc.cock]!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Fuck! Your pussy feels so good!",
										"Oh yes! Take my cock! Take it deep!",
										"Your pussy was made for my cock!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, take my cock! Your pussy belongs to me!",
										"What a horny bitch! Take my cock you slut!",
										"You feel that, fuck toy?! Do you feel my  cock sinking deep into your slutty little cunt?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Use my cock! I love your pussy!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Use me! I love your pussy!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please let me stop!",
										"Let me go! I don't want to do this!",
										"Please! Stop! I don't want this!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TAIL_PARTNER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Good [pc.girl]! Feel my [npc.tail] slide deep into your little pussy!",
										"That's right, be a good [pc.girl] and moan for me! Feel my [npc.tail] sliding deep into your cute little cunt!",
										"Your cute little cunt feels so good squeezing down around my [npc.tail]!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Fuck! Your pussy feels so good!",
										"Oh yes! Take my [npc.tail]! Take it deep!",
										"Your pussy was made for a good tail-fucking!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, feel my [npc.tail] pushing deep into your worthless little cunt! Your pussy belongs to me!",
										"What a horny bitch! Now moan for me as I fuck you with my tail!",
										"You feel that, fuck toy?! Do you feel my  [npc.tail] sinking deep into your slutty little cunt?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Use my [npc.tail]! I love your pussy!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Use me! I love your pussy!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please let me stop!",
										"Let me go! I don't want to do this!",
										"Please! Stop! I don't want this!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TONGUE_PARTNER:
						switch(Sex.getSexPacePartner()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Your pussy sure does taste good!",
										"Good [pc.girl]! I love the taste of your pussy!",
										"What a good [pc.girl]! You love my tongue in your pussy, don't you?");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Oh yes! Your pussy tastes so good!",
										"You like this? Feeling my tongue deep in your hot little cunt?!",
										"I love the taste of your pussy!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"Keep still slut, I need to practice my oral skills on you!",
										"Stay still bitch! Just keep moaning and enjoying this while it lasts!",
										"You'd better appreciate this bitch! You know how lucky you are, being used as oral practice?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! I love your pussy! You taste so good!",
										"Oh yes! Let me eat you out! Yes, yes, yes!",
										"Oh yes! I love the taste of your pussy! Let me get my [npc.tongue] nice and deep!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"I love your pussy! You taste so good!",
										"Let me eat you out! You taste good!",
										"I love the taste of your pussy!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please stop!",
										"Let me go! Get your pussy away from my face!",
										"Please! Stop! I don't want this!");
							default:
								return UtilText.returnStringAtRandom(
										"Yes! Get that tongue deeper!",
										"Oh yeah! Keep going!",
										"Deeper! Don't stop!");
						}
					default:// Self penetration:
						switch(Sex.getSexPacePartner()) {
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Go away! Leave me alone!",
										"Stop it! Just go away!",
										"Please stop! Don't do this!");
							default:
								return UtilText.returnStringAtRandom(
										"That's right, try to get yourself off!",
										"You trying to get yourself off?",
										"Yes! Keep going!");
						}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to the player having their ass used. Returns null if no penetration found.
	 */
	public String getDirtyTalkPlayerAssPenetrated(boolean isPlayerDom){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER)) {
				case FINGER_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl], you love feeling my [npc.fingers] deep in your ass, don't you?",
									"I love fingering cute little asses like yours!",
									"What a good [pc.girl]! Your ass loves the feeling of my [npc.fingers], doesn't it?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You love the feeling of my [npc.fingers] deep in your ass, don't you?!",
									"I love fingering cute little asses like yours!",
									"You like it when I curl my [npc.fingers] up inside your ass, like <i>this</i>?!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"What a dirty slut! I can feel your horny little ass clenching down on my [npc.fingers]!",
									"You love this, don't you bitch?! Feeling my [npc.fingers] pushing deep into your slutty little asshole!",
									"That's right slut! You love having my [npc.fingers] stuffed deep in your slutty ass!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Let me get my fingers deep inside your ass!",
									"I love giving your ass the attention it deserves!",
									"I love fingering your ass!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love fingering your ass!",
									"I love giving your ass the attention it deserves!",
									"I love fingering your ass!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl]! Feel my [npc.cock] slide deep into your ass!",
									"That's right, be a good [pc.girl] and moan for me! Feel my [npc.cock] sliding deep into your hot ass!",
									"Your ass feels so good squeezing down around my [npc.cock]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your ass feels so good!",
									"Oh yes! Take my cock! Take it deep!",
									"Your ass was made for my cock!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, take my cock! Your ass belongs to me!",
									"What a horny bitch! Take my cock you filthy little butt-slut!",
									"You feel that, fuck toy?! Do you feel my  cock sinking deep into your slutty little ass?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my cock! I love your ass!",
									"Don't stop! Harder! Use my cock! Yes, yes, yes!",
									"Oh yes! Use me! I love your ass!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl]! Feel my [npc.tail] slide deep into your cute little ass!",
									"That's right, be a good [pc.girl] and moan for me! Feel my [npc.tail] sliding deep into your cute little ass!",
									"Your cute little ass feels so good squeezing down around my [npc.tail]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your ass feels so good!",
									"Oh yes! Take my [npc.tail]! Take it deep into your ass!",
									"Your ass was made for a good tail-fucking!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right bitch, feel my [npc.tail] pushing deep into your slutty ass!",
									"What a horny slut! Now moan for me as I fuck your ass with my tail!",
									"You feel that, fuck toy?! Do you feel my  [npc.tail] sinking deep into your slutty little ass?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my [npc.tail]! I love your ass!",
									"Don't stop! Harder! Use my [npc.tail]! Yes, yes, yes!",
									"Oh yes! Use me! I love your ass!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, moan for me as I pleasure your ass!",
									"Good [pc.girl]! I love licking cute little asses like yours!",
									"What a good [pc.girl]! You love my tongue in your ass, don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"That's right, moan for me as I lick your ass!",
									"Feel my tongue deep in your ass! Moan for me!",
									"You love my tongue in your ass, don't you?");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Keep still slut, I need to practice my oral skills on your worthless ass!",
									"Stay still bitch! Just keep moaning and enjoying this while it lasts!",
									"You'd better appreciate this bitch! You know how lucky you are, being used as oral practice?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love your ass! Feel my [npc.tongue] pushing deep!",
									"Oh yes! Let me lick your ass! Yes, yes, yes!",
									"Oh yes! I love licking ass! Let me get my [npc.tongue] nice and deep!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love licking your ass!",
									"Let me lick your ass! I love this!",
									"I love licking your ass!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! Get your ass away from my face!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePartner()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return UtilText.returnStringAtRandom(
									"That's right, try to get yourself off!",
									"You trying to get yourself off?",
									"Yes! Keep going!");
					}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to the player having their mouth used. Returns null if no penetration found.
	 */
	public String getDirtyTalkPlayerMouthPenetrated(boolean isPlayerDom){
		
		if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER)) {
				case FINGER_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl], keep sucking on my [npc.fingers]!",
									"That's right, keep swirling your [pc.tongue] around my [npc.fingers]!",
									"What a good [pc.girl]! You love sucking on my [npc.fingers], don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You love sucking on my [npc.fingers], don't you?!",
									"That's right, keep sucking on my [npc.fingers]!",
									"Keep sucking on my [npc.fingers], just like that!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut! Suck on my [npc.fingers] like you would on a nice thick cock!",
									"You love this, don't you bitch?! Having my [npc.fingers] sliding in and out of your mouth!",
									"That's right slut! Suck on my [npc.fingers] as I stuff them deep down your throat!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Suck on my [npc.fingers]! Just like that!",
									"I love having my [npc.fingers] sucked! Keep going!",
									"Keep sucking my [npc.fingers]! Yes! Just like that!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking on my [npc.fingers]!",
									"I love having my [npc.fingers] sucked!",
									"Keep sucking my [npc.fingers]! Yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl], keep sucking my cock!",
									"That's right, use your [pc.tongue] as well! You're good at sucking cock!",
									"What a good [pc.girl]! You love sucking my cock, don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You're good at sucking cock!",
									"Oh yeah! Keep sucking my cock!",
									"Use your tongue as well! Yeah, like that!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on you slut! You can suck cock better than that!",
									"That's right bitch! Take my cock deep down your throat!",
									"Put some effort into it slut! You can suck cock better than that!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my cock! Just like that!",
									"Oh yes! Wrap those lips of yours around my cock! Keep going!",
									"Keep sucking my cock! Yes! Just like that!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my cock!",
									"Wrap those lips of yours around my cock! Keep going!",
									"Keep sucking my cock! Yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! Get off my cock!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl], keep sucking my [npc.tail]!",
									"That's right, use your [pc.tongue] as well! You're good at this!",
									"What a good [pc.girl]! You love sucking my [npc.tail], don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Take my [npc.tail] deep down your throat!",
									"Oh yeah! Keep sucking my [npc.tail]!",
									"Use your tongue as well! Yeah, like that!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on you slut! Take my [npc.tail] deep down your throat!",
									"That's right bitch! Take my [npc.tail] deep down your throat!",
									"Put some effort into it slut! You can suck my [npc.tail] better than that!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my [npc.tail]! Just like that!",
									"Oh yes! Wrap those lips of yours around my [npc.tail]! Keep going!",
									"Keep sucking my [npc.tail]! Yes! Just like that!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my [npc.tail]!",
									"Wrap those lips of yours around my [npc.tail]! Keep going!",
									"Keep sucking my [npc.tail]! Yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"I love getting my [npc.tongue] sucked!",
									"Good [pc.girl]! Keep sucking my [npc.tongue]!",
									"What a good [pc.girl]! I love having my [npc.tongue] sucked!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love getting my [npc.tongue] sucked!",
									"That's good! Keep sucking my [npc.tongue]!",
									"I love having my [npc.tongue] sucked!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on slut, you can suck my [npc.tongue] better than that!",
									"Put some more effort into this bitch! Suck my [npc.tongue] like you mean it!",
									"Fucking slut, suck my [npc.tongue]! Put some more effort into it!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Oh yes! I love having my [npc.tongue] sucked! I need more!",
									"I love having my [npc.tongue] sucked! Yes, yes, yes!",
									"Oh yes! I love having my [npc.tongue] sucked! Your lips feel so good!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love having my [npc.tongue] sucked! Keep going!",
									"Keep sucking my [npc.tongue]!",
									"I love having my [npc.tongue] sucked! Your lips feel so good!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"I love having my [npc.tongue] sucked!",
									"Oh yeah! I love having my [npc.tongue] sucked!",
									"Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePartner()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return UtilText.returnStringAtRandom(
									"That's right, try to get yourself off!",
									"You trying to get yourself off?",
									"Yes! Keep going!");
					}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to the player having their nipples used. Returns null if no penetration found.
	 */
	public String getDirtyTalkPlayerNipplePenetrated(boolean isPlayerDom){
		
		if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER)) {
				case FINGER_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl], you love feeling my [npc.fingers] deep in your nipples, don't you?",
									"I love fingering cute little nipples like yours!",
									"What a good [pc.girl]! Your tits love the feeling of my [npc.fingers], don't they?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You love the feeling of my [npc.fingers] deep in your nipples, don't you?!",
									"I love fingering cute little nipples like yours!",
									"You like it when I curl my [npc.fingers] up inside your tits, like <i>this</i>?!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"What a dirty slut! Moaning as I stuff my [npc.fingers] deep into your nipples!",
									"You love this, don't you bitch?! Feeling my [npc.fingers] pushing deep into your tits!",
									"That's right slut! You love having my [npc.fingers] stuffed deep in your slutty nipples!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Let me get my fingers deep inside your nipples!",
									"I love giving your tits the attention they deserve!",
									"I love fingering your nipples!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love fingering your nipples!",
									"I love giving your tits the attention they deserve!",
									"I love fingering your nipples!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl]! Feel my cock slide deep into your breast!",
									"That's right, be a good [pc.girl] and moan for me! Feel my [npc.cock] sliding deep into your cute little nipple!",
									"Your cute little nipple feels so good squeezing down around my [npc.cock]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your tits feel so good to fuck!",
									"Oh yes! Take my cock! Take it deep!",
									"Your tits were made for my cock!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, take my cock! Feel it pushing deep into your nipple!",
									"What a horny bitch! Taking my cock deep into your tit like a slut!",
									"You feel that, fuck toy?! Do you feel my  cock sinking deep into your slutty little nipple?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my cock! I love your tits!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Use me! I love your tits!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! Get off my cock!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [pc.girl]! Feel my [npc.tail] slide deep into your breast!",
									"That's right, be a good [pc.girl] and moan for me! Feel my [npc.tail] sliding deep into your cute little nipple!",
									"Your cute little nipple feels so good squeezing down around my [npc.tail]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your tits feel so good to fuck!",
									"Oh yes! Take my [npc.tail] deep into your nipple!",
									"Your tits were made for my [npc.tail]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, take my [npc.tail]! Feel it pushing deep into your nipple!",
									"What a horny bitch! Taking my [npc.tail] deep into your tit like a slut!",
									"You feel that, fuck toy?! Do you feel my  [npc.tail] sinking deep into your slutty little nipple?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my [npc.tail]! I love your tits!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Use me! I love your tits!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PARTNER:
					switch(Sex.getSexPacePartner()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Your nipples taste so good!",
									"Good [pc.girl]! I love the taste of your tits!",
									"What a good [pc.girl]! You love having my tongue in your nipple, don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Your tits tastes so good!",
									"You like this? Feeling my tongue deep in your hot little nipple?!",
									"I love the taste of your tits!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Keep still slut, I need to practice my skills on fuckable nipples like yours!",
									"Stay still bitch! Just keep moaning and enjoying this while it lasts!",
									"You'd better appreciate this bitch! You know how lucky you are, having me lick your nipples?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love your tits! Let me suck on your nipples!",
									"Oh yes! Let me suck on your nipples! Yes, yes, yes!",
									"Oh yes! I love your nipples! Let me get my [npc.tongue] nice and deep!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love your tits! Let me suck on your nipples!",
									"Oh yes! Let me suck on your nipples!",
									"I love your nipples! Let me get my [npc.tongue] nice and deep!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePartner()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return UtilText.returnStringAtRandom(
									"That's right, try to get yourself off!",
									"You trying to get yourself off?",
									"Yes! Keep going!");
					}
			}
		}
		
		return null;
	}
	
	// Player dirty talk for this NPC:
	
	/**
	 * @return A <b>formatted</b> piece of player speech, reacting to any current penetration.
	 */
	public String getPlayerDirtyTalk(boolean isPlayerDom) {
		if(!Main.game.isInSex()) {
			return "";
		
		} else {
			List<String> speech = new ArrayList<>(), speechSelf = new ArrayList<>();
			String s = "";
			
			// Taking vaginal:
			s = getPlayerDirtyTalkVaginaPenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Taking anal:
			s = getPlayerDirtyTalkAssPenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Taking something in their mouth:
			s = getPlayerDirtyTalkMouthPenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Taking nipple penetration:
			s = getPlayerDirtyTalkNipplePenetrated(isPlayerDom);
			if(s!=null) {
				if(!Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			
			// Giving vaginal:
			s = getPlayerDirtyTalkPartnerVaginaPenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Giving anal:
			s = getPlayerDirtyTalkPartnerAssPenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Putting something into the player's mouth:
			s = getPlayerDirtyTalkPartnerMouthPenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			// Giving nipple penetration:
			s = getPlayerDirtyTalkPartnerNipplePenetrated(isPlayerDom);
			if(s!=null) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER).isPlayer()) {
					speech.add(s);
				} else {
					speechSelf.add(s);
				}
			}
			
			
			// Choose a random line to say:
			if(!speech.isEmpty()){
				s = speech.get(Util.random.nextInt(speech.size())); // Prefer non-self penetrative speech.
				
			} else if(!speechSelf.isEmpty()){
				s = speechSelf.get(Util.random.nextInt(speechSelf.size()));
				
			} else {
				s = getPlayerDirtyTalkNoPenetration(isPlayerDom);
			}
			
			return UtilText.parseSpeech(s, Main.game.getPlayer());
		}
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to no ongoing penetration.
	 */
	public String getPlayerDirtyTalkNoPenetration(boolean isPlayerDom){
		switch(Sex.getSexPacePlayer()) {
			case DOM_GENTLE:
				return UtilText.returnStringAtRandom(
						"I'll be gentle, don't worry!",
						"You're going to be a good [npc.girl] now, aren't you?",
						"Let's have some fun!",
						"You're going to love this!");
			case DOM_NORMAL:
				return UtilText.returnStringAtRandom(
						"This is going to be good!",
						"How best to use you, I wonder...",
						"You're going to be a good [npc.girl]!",
						"Ready for some fun?");
			case DOM_ROUGH:
				return UtilText.returnStringAtRandom(
						"You ready to get fucked, slut?",
						"I'm going to fuck you senseless!",
						"You're my bitch now, understand?!",
						"I'm going to use you however I want, you fucking slut!");
			case SUB_EAGER:
				return UtilText.returnStringAtRandom(
						"Come on, fuck me already! Please!",
						"Fuck me! Please!",
						"What are you waiting for?! Come on, fuck me!",
						"I'm so horny! Please, fuck me!");
			case SUB_NORMAL:
				return UtilText.returnStringAtRandom(
						"I'll be a good [pc.girl]!",
						"I'll do whatever you want!",
						"Let's get started!",
						"Let's have some fun!");
			case SUB_RESISTING:
				return UtilText.returnStringAtRandom(
						"Go away! Leave me alone!",
						"Stop it! Just go away!",
						"Please stop! Don't do this!");
			default:
				return UtilText.returnStringAtRandom(
						"This is going to be good!",
						"Time for some fun!",
						"Let's get started!",
						"Let's have some fun!");
		}
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to having their vagina used. Returns null if no vagina or penetration found.
	 */
	public String getPlayerDirtyTalkVaginaPenetrated(boolean isPlayerDom){
		List<String> speech = new ArrayList<>();
		
		if(Main.game.getPlayer().getVaginaType()!=VaginaType.NONE) {
			if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER) != null) {
				switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER)) {
					case FINGER_PARTNER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"That's right, be a good [npc.girl] now and push your [npc.fingers] in deeper!",
										"Good [npc.girl]! Keep those [npc.fingers] of yours busy!",
										"What a good [npc.girl]! My pussy loves the feeling of your [npc.fingers]!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"That's right, push your [npc.fingers] in deep!",
										"Good [npc.girl]! Get those [npc.fingers] in deep!",
										"Keep going! Curl your [npc.fingers] up a bit!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"Come on slut, you can get your [npc.fingers] in deeper than that!",
										"Keep it up bitch! Get those [npc.fingers] in deep!",
										"Keep going slut! Curl your [npc.fingers] up and put in a little more effort!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Keep fingering me!",
										"Keep going! My pussy loves your attention!",
										"Oh yes! I love being fingered!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Keep fingering me!",
										"Keep going! I love this!",
										"Oh yes!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get your [npc.fingers] out of me! Stop! Please!",
										"Stop fingering me! Please, no more!",
										"Stop it! Stop! Please!");
							default:
								return(UtilText.returnStringAtRandom(
										"Fuck!",
										"Yeah!",
										"Oh yeah!"));
						}
					case PENIS_PARTNER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"My pussy loves your [npc.cock]!",
										"Good [npc.girl]! Keep sliding that delicious cock of yours in and out of me!",
										"What a good [npc.girl]! Enjoy my pussy as your reward now!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"You like feeling my pussy gripping down on your cock?!",
										"Good [npc.girl]! Push your [npc.cock] in deep!",
										"Keep going! Get that [npc.cock] in deep like a good [npc.girl]!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, you're my little fuck toy now!",
										"Come on bitch! You can get your worthless [npc.cock] in deeper than that!",
										"Fucking slut, put some more effort in! My pussy deserves better than your worthless [npc.cock]!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me! Fuck me harder! Don't stop!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Fuck me! I love your [npc.cock]!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get out of me! Stop! Please!",
										"Please, no more! Take your cock out!",
										"Get out of me! Stop! Please!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TAIL_PARTNER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"My pussy loves your [npc.tail]! Keep going!",
										"Good [npc.girl]! Keep fucking me with that [npc.tail] of yours!",
										"What a good [npc.girl]! Enjoy my pussy as your reward now!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Oh yes! Your [npc.tail] feels so good!",
										"Good [npc.girl]! Push your [npc.tail] in deep!",
										"Keep going! Get that [npc.tail] in deep like a good [npc.girl]!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, get that [npc.tail] in deep like a good little fuck toy!",
										"Come on bitch! You can get your [npc.tail] in deeper than that!",
										"Fucking bitch, put some more effort in! My pussy deserves better than some slut's [npc.tail]!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me! Fuck me harder! Don't stop!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Fuck me! I love your [npc.tail]! Get it deeper!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get out of me! Stop! Please!",
										"Please, no more! Take your tail out!",
										"Get out of me! Stop! Please!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TONGUE_PARTNER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"That's right, keep eating me out like a good [npc.girl]!",
										"Good [npc.girl]! Keep that [npc.tongue] of yours busy!",
										"What a good [npc.girl]! You love the taste of my pussy, don't you?!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Oh yes! Get that [npc.tongue] in deep!",
										"Good [npc.girl]! Get that [npc.tongue] of yours in deep!",
										"Keep going! My pussy loves your [npc.tongue]!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, keep eating me out like the worthless little fuck toy you are!",
										"Come on bitch! Get that [npc.tongue] of yours in deeper!",
										"Fucking bitch, put some more effort in! You know how lucky you are, being allowed to taste my pussy like this?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! I love your [npc.tongue]! Don't stop!",
										"Don't stop! Deeper! Eat me out! Yes, yes, yes!",
										"Oh yes! Taste my pussy! I love your [npc.tongue]! Get it deeper!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Don't stop!",
										"Don't stop! I love your [npc.tongue]!",
										"Oh yes! Eat me out!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Get out of me! Stop! Please!",
										"Please, no more! Take your tongue out!",
										"Get out of me! Stop! Please!");
							default:
								return UtilText.returnStringAtRandom(
										"Yes! Get that tongue deeper!",
										"Oh yeah! Keep going!",
										"Deeper! Don't stop!");
						}
					default:// Self penetration:
						switch(Sex.getSexPacePlayer()) {
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Go away! Leave me alone!",
										"Stop it! Just go away!",
										"Please stop! Don't do this!");
							default:
								return(UtilText.returnStringAtRandom(
										"Fuck!",
										"Yeah!",
										"Oh yeah!"));
						}
				}
			}
		}
		
		if(speech.isEmpty()) {
			return null;
		} else {
			return speech.get(Util.random.nextInt(speech.size()));
		}
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to having their asshole used. Returns null if no penetration found.
	 */
	public String getPlayerDirtyTalkAssPenetrated(boolean isPlayerDom){
		
		if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER)) {
				case FINGER_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, be a good [npc.girl] now and push your [npc.fingers] in deeper!",
									"Good [npc.girl]! Keep those [npc.fingers] of yours busy!",
									"What a good [npc.girl]! Keep fingering my ass!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"That's right, push your [npc.fingers] in deep!",
									"Good [npc.girl]! Get those [npc.fingers] in deep!",
									"Keep going! My ass loves the attention!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on slut, you can get your [npc.fingers] in deeper than that!",
									"Keep it up bitch! Get those [npc.fingers] in deep!",
									"Keep going slut! Get your [npc.fingers] in deep and put in a little more effort!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep fingering my ass! Don't stop!",
									"Keep going! My ass loves the attention!",
									"Oh yes! My ass loves being fingered!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Keep fingering my ass!",
									"Keep going! I love this!",
									"Oh yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop fingering my ass! Stop! Please!",
									"Please, no more! Take your fingers out of my ass!",
									"Get out of my ass! Stop! Please!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My ass loves your [npc.cock]!",
									"Good [npc.girl]! Keep sliding that delicious cock of yours in and out of my ass!",
									"What a good [npc.girl]! Enjoy my ass as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You like feeling my slutty little asshole gripping down on your cock?!",
									"Good [npc.girl]! Push your [npc.cock] in deep!",
									"Keep going! Get that [npc.cock] in deep like a good [npc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, you're my little fuck toy now!",
									"Come on bitch! You can get your worthless [npc.cock] in deeper than that!",
									"Fucking slut, put some more effort in! My ass deserves better than your worthless [npc.cock]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me! Fuck me harder! Don't stop!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Fuck me! I love your [npc.cock]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your cock out of my ass!",
									"Get out of my ass! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My ass loves your [npc.tail]! Keep going!",
									"Good [npc.girl]! Keep fucking my ass with that [npc.tail] of yours!",
									"What a good [npc.girl]! Enjoy my ass as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Your [npc.tail] feels so good!",
									"Good [npc.girl]! Push your [npc.tail] in deep!",
									"Keep going! Get that [npc.tail] in deep like a good [npc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, get that [npc.tail] in deep like a good little fuck toy!",
									"Come on bitch! You can get your [npc.tail] in deeper than that!",
									"Fucking bitch, put some more effort in! My ass deserves better than some slut's [npc.tail]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me! Fuck me harder! Don't stop!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Fuck me! I love your [npc.tail]! Get it deeper!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tail out of my ass!",
									"Get out of my ass! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, keep that rimjob going like a good [npc.girl]!",
									"Good [npc.girl]! Keep that [npc.tongue] of yours busy in my ass!",
									"What a good [npc.girl]! You love the taste of my ass, don't you?!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Get that [npc.tongue] in deep!",
									"Good [npc.girl]! Get that [npc.tongue] of yours in deep!",
									"Keep going! My ass loves your [npc.tongue]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, keep that rimjob going like the worthless little fuck toy you are!",
									"Come on bitch! Get that [npc.tongue] of yours deeper into my ass!",
									"Fucking bitch, put some more effort in! You know how lucky you are, being allowed to lick my ass like this?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love your [npc.tongue]! Don't stop!",
									"Don't stop! Deeper! Get your [npc.tongue] into my ass! Yes, yes, yes!",
									"Oh yes! Taste my ass! I love your [npc.tongue]! Get it deeper!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Don't stop!",
									"Don't stop! I love your [npc.tongue]!",
									"Oh yes! Taste my ass!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tongue out of my ass!",
									"Get your tongue out of my ass! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePlayer()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
			}
		}

		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to having their mouth used. Returns null if no penetration found.
	 */
	public String getPlayerDirtyTalkMouthPenetrated(boolean isPlayerDom){

		if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER)) {
				case FINGER_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Your fingers taste good!",
									"Good [npc.girl]! Your [npc.fingers] taste so good!",
									"What a good [npc.girl]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Your fingers taste good!",
									"Good [npc.girl]! Your [npc.fingers] taste so good!",
									"What a good [npc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Fucking slut, let's get your [npc.fingers] all nice and wet now!",
									"That's right bitch! Let's get your [npc.fingers] nice and wet!",
									"Hold still slut! I need your [npc.fingers] all nice and lubed up!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"I love the taste of your [npc.fingers]! Don't stop!",
									"Keep going! I love sucking on your [npc.fingers]!",
									"Oh yes! I love the taste of your [npc.fingers]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love the taste of your [npc.fingers]!",
									"I love sucking on your [npc.fingers]!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your fingers out of my mouth!",
									"Get out of my mouth! Stop! Please!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"I love your [npc.cock]!",
									"Good [npc.girl]! Your delicious cock deserves this nice reward!",
									"What a good [npc.girl]! I hope you're enjoying your reward!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Your cock tastes so good!",
									"I love sucking your [npc.cock]!",
									"Oh yes! Your [npc.cock] tastes so good!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Hold still slut, be a good little fuck toy and just be thankful that I love sucking cock!",
									"Stay still bitch! You'd better be happy that your worthless [npc.cock] is the only thing for me to suck right now!",
									"Fucking slut, hold still! I need to practice my oral skills on your worthless [npc.cock]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Oh yes! I love your [npc.cock]! I need it! Use my throat!",
									"Don't stop! Harder! Fuck my throat! Yes, yes, yes!",
									"Oh yes! I love your [npc.cock]! You taste so good!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love your [npc.cock]! Use my throat!",
									"Fuck my throat! Oh yes!",
									"I love your [npc.cock]! You taste so good!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your cock out of my mouth!",
									"Get your cock away from me! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"I love sucking cock!",
									"Oh yeah! I love your cock!",
									"Don't stop!");
					}
				case TAIL_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"I love sucking your [npc.tail]!",
									"Good [npc.girl]! Get this delicious [npc.tail] of yours deep down my throat!",
									"What a good [npc.girl]! I hope you're enjoying your reward!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love sucking your [npc.tail]!",
									"Good [npc.girl]! Get this delicious [npc.tail] of yours deep down my throat!",
									"What a good [npc.girl]! I hope you're enjoying your reward!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Hold still slut! Be a good little fuck toy and just be thankful that I decided to practice oral on your [npc.tail]!",
									"Stay still bitch! You'd better be happy that I decided to practice my cock-sucking on your [npc.tail]!",
									"Fucking slut, hold still! I need to practice my oral skills on your [npc.tail]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Oh yes! I love your [npc.tail]! I need it! Use my throat!",
									"Don't stop! Harder! Fuck my throat! Yes, yes, yes!",
									"Oh yes! I love your [npc.tail]! You taste so good!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love your [npc.tail]! Use my throat!",
									"Fuck my throat! Oh yes!",
									"I love your [npc.tail]! You taste so good!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tail out of my mouth!",
									"Get your tail away from me! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"I love sucking your [npc.tail]!",
									"Oh yeah! I love your [npc.tail]!",
									"Don't stop!");
					}
				case TONGUE_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Yes! Good [npc.girl]!",
									"Good [npc.girl]! I love your [npc.lips]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Good [npc.girl]!",
									"Good [npc.girl]! I love your [npc.lips]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Yes! Good bitch!",
									"Good slut! I love your [npc.lips]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Good [npc.girl]!",
									"Good [npc.girl]! I love your [npc.lips]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Good [npc.girl]!",
									"Good [npc.girl]! I love your [npc.lips]!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Stop kissing me like this!",
									"Get away from me! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Good [npc.girl]!",
									"Good [npc.girl]! I love your [npc.lips]!",
									"Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePlayer()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
			}
		}

		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to having their nipples used. Returns null if no penetration found.
	 */
	public String getPlayerDirtyTalkNipplePenetrated(boolean isPlayerDom){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER)) {
				case FINGER_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, be a good [npc.girl] now and push your [npc.fingers] deeper into my nipple!",
									"Good [npc.girl]! Keep those [npc.fingers] of yours busy in my breast!",
									"What a good [npc.girl]! My nipples love the feeling of your [npc.fingers]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"That's right, push your [npc.fingers] deep into my breast!",
									"Good [npc.girl]! Get those [npc.fingers] deep into my nipple!",
									"Keep going! Curl your [npc.fingers] up a bit!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on slut, you can get your [npc.fingers] deeper into my breast than that!",
									"Keep it up bitch! Get those [npc.fingers] deep into my nipple!",
									"Keep going slut! Curl your [npc.fingers] up and put in a little more effort!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep fingering my nipple!",
									"Keep going! My nipples love your attention!",
									"Oh yes! I love getting my nipples fingered!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Keep fingering my nipple!",
									"Keep going! I love this!",
									"Oh yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your fingers out of my nipple!",
									"Get out of my nipple! Stop! Please!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My nipples love your [npc.cock]!",
									"Good [npc.girl]! Keep sliding that delicious cock of yours in and out of my tits!",
									"What a good [npc.girl]! Enjoy my tits as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You like feeling my nipple gripping down on your cock?!",
									"Good [npc.girl]! Push your [npc.cock] deep into my breast!",
									"Keep going! Get that [npc.cock] in deep like a good [npc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, my tits could use some attention from a little fuck toy like you!",
									"Come on bitch! You can get your worthless [npc.cock] deeper into my tits than that!",
									"Fucking slut, put some more effort in! My breasts deserve better than your worthless [npc.cock]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits! Fuck them harder! Don't stop!",
									"Don't stop! Harder! Fuck my nipples! Yes, yes, yes!",
									"Oh yes! Fuck my tits! I love your [npc.cock]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits!",
									"Don't stop! Fuck my nipples!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your cock out of my breast!",
									"Get out of my nipple! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"My tits love your [npc.tail]! Keep going!",
									"Good [npc.girl]! Keep fucking my nipples with that [npc.tail] of yours!",
									"What a good [npc.girl]! Enjoy my tits as your reward now!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Your [npc.tail] feels so good!",
									"Good [npc.girl]! Push your [npc.tail] deep into my breast!",
									"Keep going! Get that [npc.tail] deep into my tits like a good [npc.girl]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, get that [npc.tail] deep into my nipple like a good little fuck toy!",
									"Come on bitch! You can get your [npc.tail] deeper into my tits than that!",
									"Fucking bitch, put some more effort in! My breasts deserve better than some slut's [npc.tail]!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits! Fuck them harder! Don't stop!",
									"Don't stop! Harder! Fuck my nipples! Yes, yes, yes!",
									"Oh yes! Fuck my tits! I love your [npc.tail]!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck my tits!",
									"Don't stop! Fuck my nipples!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tail out of my nipple!",
									"Get out of my nipple! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PARTNER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, keep sucking on my nipples like a good [npc.girl]!",
									"Good [npc.girl]! Keep that [npc.tongue] of yours busy!",
									"What a good [npc.girl]! You love my tits, don't you?!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Keep sucking on my nipples!",
									"Good [npc.girl]! Get that [npc.tongue] of yours deep into my nipples!",
									"Keep going! My tits love the feel of your [npc.tongue]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, keep sucking on my tits like the worthless little fuck toy you are!",
									"Come on bitch! Get that [npc.tongue] of yours deeper into my nipples!",
									"Fucking bitch, put some more effort in! You know how lucky you are, being allowed to suck on ym tits like this?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love the feeling of your lips on my tits! Don't stop!",
									"Don't stop! Suck on my tits! Yes, yes, yes!",
									"Oh yes! Lick my nipples! I love your [npc.tongue]! Get it deeper!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Don't stop!",
									"Don't stop! I love your [npc.tongue]!",
									"Oh yes! Suck on my tits!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Stop it! Stop! Please!",
									"Please, no more! Take your tongue out of my nipple!",
									"Leave me alone! Stop! Please!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePlayer()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to the partner having their vagina used. Returns null if no vagina or penetration found.
	 */
	public String getPlayerDirtyTalkPartnerVaginaPenetrated(boolean isPlayerDom){
		if(Sex.getPartner().getVaginaType()!=VaginaType.NONE) {
			if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER) != null) {
				switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER)) {
					case FINGER_PLAYER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Good [npc.girl], you love feeling my [pc.fingers] deep in your pussy, don't you?",
										"I love fingering cute little things like you!",
										"What a good [npc.girl]! Your pussy loves the feeling of my [pc.fingers], doesn't it?");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"You love the feeling of my [pc.fingers] deep in your pussy, don't you?!",
										"I love fingering cute [npc.girl]s like you!",
										"You like it when I curl my [pc.fingers] up inside you, like <i>this</i>?!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"What a dirty slut! I can feel your horny pussy clenching down on my [pc.fingers]!",
										"You love this, don't you bitch?! Feeling my [pc.fingers] pushing deep into your slutty cunt!",
										"That's right slut! You love having my [pc.fingers] stuffed deep in your slutty pussy!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Let me get my fingers deep inside your little pussy!",
										"I love giving your pussy the attention it deserves!",
										"I love fingering you!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"I love fingering your pussy!",
										"I love giving your pussy the attention it deserves!",
										"I love fingering you!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please let me stop!",
										"Let me go! I don't want to do this!",
										"Please! Stop! I don't want this!");
							default:
								return(UtilText.returnStringAtRandom(
										"Fuck!",
										"Yeah!",
										"Oh yeah!"));
						}
					case PENIS_PLAYER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Good [npc.girl]! Feel my [pc.cock] slide deep into your little pussy!",
										"That's right, be a good [npc.girl] and moan for me! Feel my [pc.cock] sliding deep into your cute little cunt!",
										"Your cute little cunt feels so good squeezing down around my [pc.cock]!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Fuck! Your pussy feels so good!",
										"Oh yes! Take my cock! Take it deep!",
										"Your pussy was made for my cock!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, take my cock! Your pussy belongs to me!",
										"What a horny bitch! Take my cock you slut!",
										"You feel that, fuck toy?! Do you feel my  cock sinking deep into your slutty little cunt?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Use my cock! I love your pussy!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Use me! I love your pussy!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please let me stop!",
										"Let me go! I don't want to do this!",
										"Please! Stop! I don't want this!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TAIL_PLAYER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Good [npc.girl]! Feel my [pc.tail] slide deep into your little pussy!",
										"That's right, be a good [npc.girl] and moan for me! Feel my [pc.tail] sliding deep into your cute little cunt!",
										"Your cute little cunt feels so good squeezing down around my [pc.tail]!");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Fuck! Your pussy feels so good!",
										"Oh yes! Take my [pc.tail]! Take it deep!",
										"Your pussy was made for a good tail-fucking!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"That's right slut, feel my [pc.tail] pushing deep into your worthless little cunt! Your pussy belongs to me!",
										"What a horny bitch! Now moan for me as I fuck you with my tail!",
										"You feel that, fuck toy?! Do you feel my  [pc.tail] sinking deep into your slutty little cunt?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! Use my [pc.tail]! I love your pussy!",
										"Don't stop! Harder! Fuck me! Yes, yes, yes!",
										"Oh yes! Use me! I love your pussy!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"Yes! Fuck me!",
										"Don't stop! Fuck me!",
										"Oh yes! Fuck me!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please let me stop!",
										"Let me go! I don't want to do this!",
										"Please! Stop! I don't want this!");
							default:
								return UtilText.returnStringAtRandom(
										"Fuck me! Yes! Harder!",
										"Oh yeah! Fuck me!",
										"Harder! Don't stop!");
						}
					case TONGUE_PLAYER:
						switch(Sex.getSexPacePlayer()) {
							case DOM_GENTLE:
								return UtilText.returnStringAtRandom(
										"Your pussy sure does taste good!",
										"Good [npc.girl]! I love the taste of your pussy!",
										"What a good [npc.girl]! You love my tongue in your pussy, don't you?");
							case DOM_NORMAL:
								return UtilText.returnStringAtRandom(
										"Oh yes! Your pussy tastes so good!",
										"You like this? Feeling my tongue deep in your hot little cunt?!",
										"I love the taste of your pussy!");
							case DOM_ROUGH:
								return UtilText.returnStringAtRandom(
										"Keep still slut, I need to practice my oral skills on you!",
										"Stay still bitch! Just keep moaning and enjoying this while it lasts!",
										"You'd better appreciate this bitch! You know how lucky you are, being used as oral practice?!");
							case SUB_EAGER:
								return UtilText.returnStringAtRandom(
										"Yes! I love your pussy! You taste so good!",
										"Oh yes! Let me eat you out! Yes, yes, yes!",
										"Oh yes! I love the taste of your pussy! Let me get my [pc.tongue] nice and deep!");
							case SUB_NORMAL:
								return UtilText.returnStringAtRandom(
										"I love your pussy! You taste so good!",
										"Your pussy tastes so good!",
										"I love the taste of your pussy!");
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"I don't want to do this! Please let me stop!",
										"Let me go! Get your pussy away from my face!",
										"Please! Stop! I don't want this!");
							default:
								return UtilText.returnStringAtRandom(
										"Yes! Get that tongue deeper!",
										"Oh yeah! Keep going!",
										"Deeper! Don't stop!");
						}
					default:// Self penetration:
						switch(Sex.getSexPacePlayer()) {
							case SUB_RESISTING:
								return UtilText.returnStringAtRandom(
										"Go away! Leave me alone!",
										"Stop it! Just go away!",
										"Please stop! Don't do this!");
							default:
								return UtilText.returnStringAtRandom(
										"That's right, try to get yourself off!",
										"You trying to get yourself off?",
										"Yes! Keep going!");
						}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to the partner having their ass used. Returns null if no penetration found.
	 */
	public String getPlayerDirtyTalkPartnerAssPenetrated(boolean isPlayerDom){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER)) {
				case FINGER_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl], you love feeling my [pc.fingers] deep in your ass, don't you?",
									"I love fingering cute little asses like yours!",
									"What a good [npc.girl]! Your ass loves the feeling of my [pc.fingers], doesn't it?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You love the feeling of my [pc.fingers] deep in your ass, don't you?!",
									"I love fingering cute little asses like yours!",
									"You like it when I curl my [pc.fingers] up inside your ass, like <i>this</i>?!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"What a dirty slut! I can feel your horny little ass clenching down on my [pc.fingers]!",
									"You love this, don't you bitch?! Feeling my [pc.fingers] pushing deep into your slutty little asshole!",
									"That's right slut! You love having my [pc.fingers] stuffed deep in your slutty ass!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Let me get my fingers deep inside your ass!",
									"I love giving your ass the attention it deserves!",
									"I love fingering your ass!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love fingering your ass!",
									"I love giving your ass the attention it deserves!",
									"I love fingering your ass!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl]! Feel my [pc.cock] slide deep into your ass!",
									"That's right, be a good [npc.girl] and moan for me! Feel my [pc.cock] sliding deep into your hot ass!",
									"Your ass feels so good squeezing down around my [pc.cock]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your ass feels so good!",
									"Oh yes! Take my cock! Take it deep!",
									"Your ass was made for my cock!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, take my cock! Your ass belongs to me!",
									"What a horny bitch! Take my cock you filthy little butt-slut!",
									"You feel that, fuck toy?! Do you feel my  cock sinking deep into your slutty little ass?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my cock! I love your ass!",
									"Don't stop! Harder! Use my cock! Yes, yes, yes!",
									"Oh yes! Use me! I love your ass!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl]! Feel my [pc.tail] slide deep into your cute little ass!",
									"That's right, be a good [npc.girl] and moan for me! Feel my [pc.tail] sliding deep into your cute little ass!",
									"Your cute little ass feels so good squeezing down around my [pc.tail]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your ass feels so good!",
									"Oh yes! Take my [pc.tail]! Take it deep into your ass!",
									"Your ass was made for a good tail-fucking!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right bitch, feel my [pc.tail] pushing deep into your slutty ass!",
									"What a horny slut! Now moan for me as I fuck your ass with my tail!",
									"You feel that, fuck toy?! Do you feel my  [pc.tail] sinking deep into your slutty little ass?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my [pc.tail]! I love your ass!",
									"Don't stop! Harder! Use my [pc.tail]! Yes, yes, yes!",
									"Oh yes! Use me! I love your ass!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"That's right, moan for me as I pleasure your ass!",
									"Good [npc.girl]! I love licking cute little asses like yours!",
									"What a good [npc.girl]! You love my tongue in your ass, don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"That's right, moan for me as I lick your ass!",
									"Feel my tongue deep in your ass! Moan for me!",
									"You love my tongue in your ass, don't you?");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Keep still slut, I need to practice my oral skills on your worthless ass!",
									"Stay still bitch! Just keep moaning and enjoying this while it lasts!",
									"You'd better appreciate this bitch! You know how lucky you are, being used as oral practice?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love your ass! Feel my [pc.tongue] pushing deep!",
									"Oh yes! Let me lick your ass! Yes, yes, yes!",
									"Oh yes! I love licking ass! Let me get my [pc.tongue] nice and deep!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love licking your ass!",
									"Let me lick your ass! I love this!",
									"I love licking your ass!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! Get your ass away from my face!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePlayer()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return UtilText.returnStringAtRandom(
									"That's right, try to get yourself off!",
									"You trying to get yourself off?",
									"Yes! Keep going!");
					}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to the partner having their mouth used. Returns null if no penetration found.
	 */
	public String getPlayerDirtyTalkPartnerMouthPenetrated(boolean isPlayerDom){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER)) {
				case FINGER_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl], keep sucking on my [pc.fingers]!",
									"That's right, keep swirling your [npc.tongue] around my [pc.fingers]!",
									"What a good [npc.girl]! You love sucking on my [pc.fingers], don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You love sucking on my [pc.fingers], don't you?!",
									"That's right, keep sucking on my [pc.fingers]!",
									"Keep sucking on my [pc.fingers], just like that!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut! Suck on my [pc.fingers] like you would on a nice thick cock!",
									"You love this, don't you bitch?! Having my [pc.fingers] sliding in and out of your mouth!",
									"That's right slut! Suck on my [pc.fingers] as I stuff them deep down your throat!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Suck on my [pc.fingers]! Just like that!",
									"I love having my [pc.fingers] sucked! Keep going!",
									"Keep sucking my [pc.fingers]! Yes! Just like that!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking on my [pc.fingers]!",
									"I love having my [pc.fingers] sucked!",
									"Keep sucking my [pc.fingers]! Yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl], keep sucking my cock!",
									"That's right, use your [npc.tongue] as well! You're good at sucking cock!",
									"What a good [npc.girl]! You love sucking my cock, don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You're good at sucking cock!",
									"Oh yeah! Keep sucking my cock!",
									"Use your tongue as well! Yeah, like that!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on you slut! You can suck cock better than that!",
									"That's right bitch! Take my cock deep down your throat!",
									"Put some effort into it slut! You can suck cock better than that!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my cock! Just like that!",
									"Oh yes! Wrap those lips of yours around my cock! Keep going!",
									"Keep sucking my cock! Yes! Just like that!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my cock!",
									"Wrap those lips of yours around my cock! Keep going!",
									"Keep sucking my cock! Yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! Get off my cock!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl], keep sucking my [pc.tail]!",
									"That's right, use your [npc.tongue] as well! You're good at this!",
									"What a good [npc.girl]! You love sucking my [pc.tail], don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Take my [pc.tail] deep down your throat!",
									"Oh yeah! Keep sucking my [pc.tail]!",
									"Use your tongue as well! Yeah, like that!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on you slut! Take my [pc.tail] deep down your throat!",
									"That's right bitch! Take my [pc.tail] deep down your throat!",
									"Put some effort into it slut! You can suck my [pc.tail] better than that!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my [pc.tail]! Just like that!",
									"Oh yes! Wrap those lips of yours around my [pc.tail]! Keep going!",
									"Keep sucking my [pc.tail]! Yes! Just like that!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Keep sucking my [pc.tail]!",
									"Wrap those lips of yours around my [pc.tail]! Keep going!",
									"Keep sucking my [pc.tail]! Yes!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"I love getting my [pc.tongue] sucked!",
									"Good [npc.girl]! Keep sucking my [pc.tongue]!",
									"What a good [npc.girl]! I love having my [pc.tongue] sucked!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love getting my [pc.tongue] sucked!",
									"That's good! Keep sucking my [pc.tongue]!",
									"I love having my [pc.tongue] sucked!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Come on slut, you can suck my [pc.tongue] better than that!",
									"Put some more effort into this bitch! Suck my [pc.tongue] like you mean it!",
									"Fucking slut, suck my [pc.tongue]! Put some more effort into it!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Oh yes! I love having my [pc.tongue] sucked! I need more!",
									"I love having my [pc.tongue] sucked! Yes, yes, yes!",
									"Oh yes! I love having my [pc.tongue] sucked! Your lips feel so good!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love having my [pc.tongue] sucked! Keep going!",
									"Keep sucking my [pc.tongue]!",
									"I love having my [pc.tongue] sucked! Your lips feel so good!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"I love having my [pc.tongue] sucked!",
									"Oh yeah! I love having my [pc.tongue] sucked!",
									"Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePlayer()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return UtilText.returnStringAtRandom(
									"That's right, try to get yourself off!",
									"You trying to get yourself off?",
									"Yes! Keep going!");
					}
			}
		}
		
		return null;
	}
	
	/**
	 * @return A <b>non-formatted</b> String of the player's speech related to the partner having their nipples used. Returns null if no penetration found.
	 */
	public String getPlayerDirtyTalkPartnerNipplePenetrated(boolean isPlayerDom){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER) != null) {
			switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER)) {
				case FINGER_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl], you love feeling my [pc.fingers] deep in your nipples, don't you?",
									"I love fingering cute little nipples like yours!",
									"What a good [npc.girl]! Your tits love the feeling of my [pc.fingers], don't they?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"You love the feeling of my [pc.fingers] deep in your nipples, don't you?!",
									"I love fingering cute little nipples like yours!",
									"You like it when I curl my [pc.fingers] up inside your tits, like <i>this</i>?!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"What a dirty slut! Moaning as I stuff my [pc.fingers] deep into your nipples!",
									"You love this, don't you bitch?! Feeling my [pc.fingers] pushing deep into your tits!",
									"That's right slut! You love having my [pc.fingers] stuffed deep in your slutty nipples!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Let me get my fingers deep inside your nipples!",
									"I love giving your tits the attention they deserve!",
									"I love fingering your nipples!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love fingering your nipples!",
									"I love giving your tits the attention they deserve!",
									"I love fingering your nipples!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return(UtilText.returnStringAtRandom(
									"Fuck!",
									"Yeah!",
									"Oh yeah!"));
					}
				case PENIS_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl]! Feel my cock slide deep into your breast!",
									"That's right, be a good [npc.girl] and moan for me! Feel my [pc.cock] sliding deep into your cute little nipple!",
									"Your cute little nipple feels so good squeezing down around my [pc.cock]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your tits feel so good to fuck!",
									"Oh yes! Take my cock! Take it deep!",
									"Your tits were made for my cock!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, take my cock! Feel it pushing deep into your nipple!",
									"What a horny bitch! Taking my cock deep into your tit like a slut!",
									"You feel that, fuck toy?! Do you feel my  cock sinking deep into your slutty little nipple?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my cock! I love your tits!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Use me! I love your tits!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! Get off my cock!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TAIL_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Good [npc.girl]! Feel my [pc.tail] slide deep into your breast!",
									"That's right, be a good [npc.girl] and moan for me! Feel my [pc.tail] sliding deep into your cute little nipple!",
									"Your cute little nipple feels so good squeezing down around my [pc.tail]!");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Fuck! Your tits feel so good to fuck!",
									"Oh yes! Take my [pc.tail] deep into your nipple!",
									"Your tits were made for my [pc.tail]!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"That's right slut, take my [pc.tail]! Feel it pushing deep into your nipple!",
									"What a horny bitch! Taking my [pc.tail] deep into your tit like a slut!",
									"You feel that, fuck toy?! Do you feel my  [pc.tail] sinking deep into your slutty little nipple?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! Use my [pc.tail]! I love your tits!",
									"Don't stop! Harder! Fuck me! Yes, yes, yes!",
									"Oh yes! Use me! I love your tits!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"Yes! Fuck me!",
									"Don't stop! Fuck me!",
									"Oh yes! Fuck me!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Fuck me! Yes! Harder!",
									"Oh yeah! Fuck me!",
									"Harder! Don't stop!");
					}
				case TONGUE_PLAYER:
					switch(Sex.getSexPacePlayer()) {
						case DOM_GENTLE:
							return UtilText.returnStringAtRandom(
									"Your nipples taste so good!",
									"Good [npc.girl]! I love the taste of your tits!",
									"What a good [npc.girl]! You love having my tongue in your nipple, don't you?");
						case DOM_NORMAL:
							return UtilText.returnStringAtRandom(
									"Oh yes! Your tits tastes so good!",
									"You like this? Feeling my tongue deep in your hot little nipple?!",
									"I love the taste of your tits!");
						case DOM_ROUGH:
							return UtilText.returnStringAtRandom(
									"Keep still slut, I need to practice my skills on fuckable nipples like yours!",
									"Stay still bitch! Just keep moaning and enjoying this while it lasts!",
									"You'd better appreciate this bitch! You know how lucky you are, having me lick your nipples?!");
						case SUB_EAGER:
							return UtilText.returnStringAtRandom(
									"Yes! I love your tits! Let me suck on your nipples!",
									"Oh yes! Let me suck on your nipples! Yes, yes, yes!",
									"Oh yes! I love your nipples! Let me get my [pc.tongue] nice and deep!");
						case SUB_NORMAL:
							return UtilText.returnStringAtRandom(
									"I love your tits! Let me suck on your nipples!",
									"Oh yes! Let me suck on your nipples!",
									"I love your nipples! Let me get my [pc.tongue] nice and deep!");
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"I don't want to do this! Please let me stop!",
									"Let me go! I don't want to do this!",
									"Please! Stop! I don't want this!");
						default:
							return UtilText.returnStringAtRandom(
									"Yes! Get that tongue deeper!",
									"Oh yeah! Keep going!",
									"Deeper! Don't stop!");
					}
				default:// Self penetration:
					switch(Sex.getSexPacePlayer()) {
						case SUB_RESISTING:
							return UtilText.returnStringAtRandom(
									"Go away! Leave me alone!",
									"Stop it! Just go away!",
									"Please stop! Don't do this!");
						default:
							return UtilText.returnStringAtRandom(
									"That's right, try to get yourself off!",
									"You trying to get yourself off?",
									"Yes! Keep going!");
					}
			}
		}
		
		return null;
	}
	
	
	
	// Player area reveals:

	public String getPlayerAssRevealReaction(boolean isPlayerDom) {
		switch(Sex.getSexPacePartner()) {
			case DOM_GENTLE:
				return "<p>"
							+ "[npc.Name] lets out a soft [npc.moan] as your [pc.asshole+] is revealed."
						+ "</p>";
			case DOM_NORMAL:
				return "<p>"
							+ "[npc.Name] lets out [npc.a_moan+] as your [pc.asshole+] is revealed."
						+ "</p>";
			case DOM_ROUGH:
				return "<p>"
							+ "[npc.Name] lets out a hungry growl as your [pc.asshole+] is revealed."
						+ "</p>";
			case SUB_EAGER:
				return "<p>"
							+ "[npc.Name] lets out [npc.a_moan+] as your [pc.asshole+] is revealed."
						+ "</p>";
			case SUB_NORMAL:
				return "<p>"
							+ "[npc.Name] lets out [npc.a_moan] as your [pc.asshole+] is revealed."
						+ "</p>";
			case SUB_RESISTING:
				return "<p>"
							+ "[npc.Name] lets out [npc.a_sob+] as your [pc.asshole+] is revealed."
						+ "</p>";
			default:
				return "<p>"
							+ "[npc.Name] lets out [npc.a_moan] as your [pc.asshole+] is revealed."
						+ "</p>";
		}
	}

	public String getPlayerBreastsRevealReaction(boolean isPlayerDom) {
		if(Sex.isConsensual()) {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return "<p>"
								+ "[npc.Name] lets out a soft [npc.moan] as your [pc.breasts+] are revealed."
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your [pc.breasts+] are revealed."
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] lets out a hungry growl as your [pc.breasts+] are revealed."
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your [pc.breasts+] are revealed."
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.breasts+] are revealed."
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob+] as your [pc.breasts+] are revealed."
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.breasts+] are revealed."
							+ "</p>";
			}
			
		} else if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
			return "<p>"
					+ "[npc.Name] lets out [npc.a_sob+] as your [pc.breasts+] are revealed."
				+ "</p>";
			
		} else {
			if(isPlayerDom) {
				// Feminine NPC:
				if(isFeminine()) {
					if (Main.game.getPlayer().isFeminine()) {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "<p>"
									+ "[npc.Name] struggles to stifle a mocking laugh as your flat chest is revealed, "
									+ UtilText.parseSpeech("Pfft-hahaha!", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							if(Sex.getPartner().getBreastSize().getMeasurement() >= Main.game.getPlayer().getBreastSize().getMeasurement()) {
								return "<p>"
										+ "[npc.Name] puts on a patronising smile as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Aww... They're pretty cute!", Sex.getPartner())
										+ "</p>";
								
							} else {
								return "<p>"
										+ "[npc.Name] looks embarrassed as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("They're so much bigger than mine...", Sex.getPartner())
										+ "</p>";
							}
							
						} else {
							return "<p>"
									+ "[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
									+ UtilText.parseSpeech("How much bubble milk have you been drinking?!", Sex.getPartner())
									+ "</p>";
						}
						
					} else {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.C.getMeasurement()) {
							return "<p>"
									+ "In a very patronising voice, [npc.name] reacts to your breasts being revealed, "
									+ UtilText.parseSpeech("Aww, you trying to become a girl?", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							if(Sex.getPartner().getBreastSize().getMeasurement() >= Main.game.getPlayer().getBreastSize().getMeasurement()) {
								return "<p>"
										+ "[npc.Name] looks surprised as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Why would a guy have tits like that?", Sex.getPartner())
										+ "</p>";
								
							} else {
								return "<p>"
										+ "[npc.Name] fails to contain [npc.her] surprise as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("A <i>guy</i> has bigger tits than me?!", Sex.getPartner())
										+ "</p>";
							}
		
						} else {
							return "<p>"
									+ "[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
									+ UtilText.parseSpeech("How much bubble milk have you been drinking?!", Sex.getPartner())
									+ "</p>";
						}
						
					}
					
				// Masculine NPC:
				} else {
					if (Main.game.getPlayer().isFeminine()) {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "<p>"
									+ "[npc.Name] struggles to stifle a mocking laugh as your flat chest is revealed, "
									+ UtilText.parseSpeech("Pfft-hahaha!", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.C.getMeasurement()) {
							return "<p>"
									+ "[npc.Name] lets out a disappointed hum as your [pc.breastSize] breasts are revealed, "
									+ UtilText.parseSpeech("Huh... They're pretty small you know...", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							return (UtilText.parse(Sex.getPartner(),
										"[npc.Name]'s eyes light up as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Oh fuck yeah... Look at the size of those tits!", Sex.getPartner()))
									+ "</p>");
							
						} else {
							return (UtilText.parse(Sex.getPartner(),
										"[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("How much bubble milk have you been drinking?!", Sex.getPartner()))
									+ "</p>");
						}
						
					} else {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.C.getMeasurement()) {
							return (
									"<p>"
										+ "In a mocking tone, [npc.name] questions you as your tiny breasts are revealed, "
										+ UtilText.parseSpeech("Hah, you trying to become a girl?", Sex.getPartner())
									+ "</p>");
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.FF.getMeasurement()) {
							return (
									"<p>"
										+ "[npc.Name] looks surprised as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Why would a guy have tits like that?", Sex.getPartner())
									+ "</p>");
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							return (
									"<p>"
										+ "[npc.Name] fails to contain his surprise as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("What's a <i>guy</i> doing with such massive tits?!", Sex.getPartner())
									+ "</p>");
							
						} else {
							return (
									"<p>"
										+ "[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("How much bubble milk have you been drinking?!", Sex.getPartner())
									+ "</p>");
						}
						
					}
				}
				
			} else {
				// Feminine NPC:
				if(isFeminine()) {
					if (Main.game.getPlayer().isFeminine()) {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "<p>"
									+ "[npc.Name] lets out a mocking laugh as your flat chest is revealed, "
									+ UtilText.parseSpeech("Hahaha, I don't think I've ever seen a girl with a chest <i>that</i> flat before!", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							if(Sex.getPartner().getBreastSize().getMeasurement() >= Main.game.getPlayer().getBreastSize().getMeasurement()) {
								return "<p>"
										+ "[npc.Name] grins down at you as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Aww, look at those tiny little things, how cute!", Sex.getPartner())
										+ "</p>";
								
							} else {
								return "<p>"
										+ Sex.getPartner().getName("The")
										+ " looks annoyed as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Are you trying to put me to shame or something?!", Sex.getPartner())
										+ "</p>";
							}
		
						} else {
							return "<p>"
									+ "[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
									+ UtilText.parseSpeech("How much bubble milk have you been drinking?!", Sex.getPartner())
									+ "</p>";
						}
		
					} else {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.C.getMeasurement()) {
							return "<p>"
									+ "[npc.Name] grins at you as your [pc.breastSize] breasts are revealed, "
									+ UtilText.parseSpeech("Aww, you trying to become a girl?", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							if(Sex.getPartner().getBreastSize().getMeasurement() >= Main.game.getPlayer().getBreastSize().getMeasurement()) {
								return "<p>"
										+ "[npc.Name] looks surprised as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Why would a guy have tits like that?", Sex.getPartner())
										+ "</p>";
								
							} else {
								return "<p>"
										+ "[npc.Name] looks annoyed as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Are you kidding me?! A <i>guy</i> has bigger tits than me?!", Sex.getPartner())
										+ "</p>";
							}
		
						} else {
							return "<p>"
									+ "[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
									+ UtilText.parseSpeech("How much bubble milk have you been drinking?!", Sex.getPartner())
									+ "</p>";
						}
						
					}
					
				// Masculine NPC:
				} else {
					if (Main.game.getPlayer().isFeminine()) {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "<p>"
										+ "[npc.Name] lets out a mocking laugh as your flat chest is revealed, "
										+ UtilText.parseSpeech("Hahaha, I don't think I've ever seen a girl with a chest <i>that</i> flat before!", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.C.getMeasurement()) {
							return "<p>"
										+ "[npc.Name] growls down at you as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("I like my girls with bigger tits than that!", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.FF.getMeasurement()) {
							return "<p>"
										+ "[npc.Name] grins as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Mmm yeah, those are some nice tits!", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							return "<p>"
										+ "[npc.Name] looks delighted as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Oh fuck yeah! Look at the size of those things!", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"
										+ "[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("How much bubble milk have you been drinking?! What a fucking tit-cow!", Sex.getPartner())
									+ "</p>";
						}
						
					} else {
						if (!Main.game.getPlayer().hasBreasts()) {
							return "";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.C.getMeasurement()) {
							return "<p>"
										+ "[npc.Name] bursts out laughing as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Hahaha, you trying to become a girl?!", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.FF.getMeasurement()) {
							return "<p>"
										+ "[npc.Name] looks surprised as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Why would a guy have tits like that?!", Sex.getPartner())
									+ "</p>";
							
						} else if (Main.game.getPlayer().getBreastRawSizeValue() <= CupSize.JJ.getMeasurement()) {
							return "<p>"
										+ "[npc.Name] lets out a mocking laugh as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("Are you kidding me?! Why does a <i>guy</i> have tits like that?!", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"
										+ "[npc.Name]'s jaw drops as your [pc.breastSize] breasts are revealed, "
										+ UtilText.parseSpeech("How much bubble milk have you been drinking?!", Sex.getPartner())
									+ "</p>";
						}
					}
				}
			}
		}
	}

	public String getPlayerPenisRevealReaction(boolean isPlayerDom) {
		if(Sex.isConsensual()) {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return "<p>"
								+ "[npc.Name] lets out a soft [npc.moan] as your [pc.penis+] is revealed."
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your [pc.penis+] is revealed."
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] lets out a hungry growl as your [pc.penis+] is revealed."
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your [pc.penis+] is revealed."
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.penis+] is revealed."
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob+] as your [pc.penis+] is revealed."
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.penis+] is revealed."
							+ "</p>";
			}
			
		} else if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
			return "<p>"
					+ "[npc.Name] lets out [npc.a_sob+] as your [pc.penis+] is revealed, [npc.speech(No, don't!)]"
				+ "</p>";
			
		} else {
			// Feminine NPC:
			if(isFeminine()) {
				if(isPlayerDom) {
					if (Main.game.getPlayer().isFeminine()) {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"+
										"[npc.Name] fails to suppress a little giggle as your tiny [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Aww, that's so cute! I didn't realise you were [pc.a_gender]!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"+
										"[npc.Name] lets out a surprised gasp as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Ooh! You're [pc.a_gender]?!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"+
										"[npc.Name] grins as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Y'know, what with the bulge and everything, it was pretty obvious you're [pc.a_gender]!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"+
										"Her eyes open wide as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("I mean, I could see it was big from your bulge, but damn! I've never seen [pc.a_gender] with such a huge cock!", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"+
										"[npc.Name]'s jaw drops as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Holy shit! I didn't think [pc.gender]s could get cocks like that!", Sex.getPartner())
									+ "</p>";
						}
						
					} else {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"+
										"[npc.She] fails to suppress a mocking laugh as your tiny [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Hahaha, that's so pathetic! It's like a little clit!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"+
										"[npc.She] lets out a patronising 'aww' as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Look at that cute little thing!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"+
										"[npc.She] grins as your [pc.cockSize] [pc.cock] is revealed, "
											+ UtilText.parseSpeech("~Mmm!~ Now that's what I like to see!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"+
										"Her eyes open wide as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Oh wow... This is gonna be good!", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"+
										"[npc.Name]'s jaw drops as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Holy shit! Now <i>that's</i> a cock!", Sex.getPartner())
									+ "</p>";
						}
					}
					
				} else {
					if (Main.game.getPlayer().isFeminine()) {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"
									+ "[npc.She] lets out a little giggle as your tiny [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Aww, that's so cute! I didn't realise you were [pc.a_gender]!", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"
									+ "[npc.She] lets out a surprised gasp as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Ooh! You're a cute little [pc.gender], aren't you?!", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"
									+ "[npc.She] grins as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Y'know, what with the bulge and everything, it was pretty obvious you're [pc.a_gender]!", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"
									+ "[npc.Her] eyes open wide as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("I mean, I could see it was big from your bulge, but damn! I've never seen [pc.a_gender] with such a huge cock!", Sex.getPartner())
									+ "</p>";
		
						} else {
							return "<p>"
									+ "[npc.Her] jaw drops as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Holy shit! I didn't think [pc.gender]s could get cocks like that!", Sex.getPartner())
									+ "</p>";
						}
		
					} else {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"
									+ "[npc.She] lets out a mocking laugh as your tiny [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Hahaha, that's so pathetic!", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"
									+ "[npc.She] lets out a patronising 'aww' as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Look at that cute little thing!", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"
									+ "[npc.She] grins as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("~Mmm!~ That looks pretty good!", Sex.getPartner())
									+ "</p>";
		
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"
									+ "Her eyes open wide as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Oh wow...", Sex.getPartner())
									+ "</p>";
		
						} else {
							return "<p>"
									+ "[npc.Her] jaw drops as your [pc.cockSize] [pc.cock] is revealed, "
									+ UtilText.parseSpeech("Holy shit! Now <i>that's</i> a cock!", Sex.getPartner())
									+ "</p>";
						}
					}
				}
				
			// Masculine NPC:
			} else {
				if(isPlayerDom){
					if (Main.game.getPlayer().isFeminine()) {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your tiny [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Wait, what?! I thought you were a girl... Well, it looks cute enough...", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Wait, what?! You're [pc.a_gender]?!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("I should have guessed from that bulge...", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("I saw you had a bulge, but what the hell?! How does [pc.a_gender] have a bigger cock than <i>me</i>?!", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"
										+ "[npc.Name]'s jaw drops as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Holy shit! I didn't think "+Main.game.getPlayer().getGender().getName()+"s could get cocks that big!", Sex.getPartner())
									+ "</p>";
						}
						
					} else {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] struggles to suppress a mocking grunt as your tiny [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Pfft! What a cute little thing...", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a patronising grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Hah! Look at that little thing!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Huh... That's just as big as mine...", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Fuck... It's even bigger than mine!", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"
										+ "[npc.Name] gulps nervously as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Fuck... That's pretty big...", Sex.getPartner())
									+ "</p>";
						}
					}
					
				} else {
					if (Main.game.getPlayer().isFeminine()) {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your tiny [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Wait, what?! I thought you were a girl! Well, it doesn't really matter...", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Wait, what?! You're [pc.a_gender]?!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("I should have guessed from that bulge...", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("I saw you had a bulge, but what the hell?! How does [pc.a_gender] have a bigger cock than <i>me</i>?!", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"
										+ "[npc.Name]'s jaw drops as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Holy shit! I didn't think [pc.gender]s could get cocks that big!", Sex.getPartner())
									+ "</p>";
						}
						
					} else {
						if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.ONE_TINY.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a derisive sneer as your tiny [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Hah! That's so pathetic! I'll show you what a real man's cock is like!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.TWO_AVERAGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a patronising sneer as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Hah! Look at that little thing!", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.FOUR_HUGE.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a derisive sneer as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Huh... Trying to compete with me for size are you?", Sex.getPartner())
									+ "</p>";
				
						} else if (Main.game.getPlayer().getPenisRawSizeValue() <= PenisSize.SIX_GIGANTIC.getMaximumValue()) {
							return "<p>"
										+ "[npc.Name] lets out a surprised grunt as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Fuck... You're even bigger than me...", Sex.getPartner())
									+ "</p>";
							
						} else {
							return "<p>"
										+ "[npc.Name]'s jaw drops as your [pc.cockSize] [pc.cock] is revealed, "
										+ UtilText.parseSpeech("Fuck...", Sex.getPartner())
									+ "</p>";
						}
					}
				}
			}
		}
	}

	public String getPlayerVaginaRevealReaction(boolean isPlayerDom) {
		if(Sex.isConsensual()) {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return "<p>"
								+ "[npc.Name] lets out a soft [npc.moan] as your [pc.pussy+] is revealed."
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your [pc.pussy+] is revealed."
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] lets out a hungry growl as your [pc.pussy+] is revealed."
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your [pc.pussy+] is revealed."
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.pussy+] is revealed."
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob+] as your [pc.pussy+] is revealed."
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.pussy+] is revealed."
							+ "</p>";
			}
			
		} else if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
			return "<p>"
					+ "[npc.Name] lets out [npc.a_sob+] as your [pc.pussy+] is revealed, [npc.speech(Stop it! Go away!)]"
				+ "</p>";
			
		} else {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return "<p>"
							+ "[npc.Name] lets out a soft [npc.moan] as [npc.she] sees "
									+ (Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).contains(LubricationType.PLAYER_NATURAL_LUBRICATION)
											? "your wet [pc.pussy] betraying your arousal, "
											: "your [pc.pussy+], ")
									+ (Sex.getPartner().hasPenis()
											?"[npc.speech(You're going to love this, I promise...)]"
											:"[npc.speech(I'll make this feel good, I promise...)]")
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
							+ "[npc.Name] lets out a soft [npc.moan] as [npc.she] sees "
									+ (Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).contains(LubricationType.PLAYER_NATURAL_LUBRICATION)
											? "your wet [pc.pussy] betraying your arousal, "
											: "your [pc.pussy+], ")
									+ (Sex.getPartner().hasPenis()
											?"[npc.speech(You're going to be a good fuck!)]"
											:"[npc.speech(This is going to be fun!)]")
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
							+ "[npc.Name] smirks when [npc.she] sees "
									+ (Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).contains(LubricationType.PLAYER_NATURAL_LUBRICATION)
											? "your wet [pc.pussy] betraying your arousal, "
											: "your [pc.pussy+], ")
									+ (Sex.getPartner().hasPenis()
											?"[npc.speech(Ready for a good hard fucking, slut?)]"
											:"[npc.speech(Looking good, slut!)]")
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
							+ "[npc.Name]'s eyes light up when [npc.she] sees "
							+ (Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).contains(LubricationType.PLAYER_NATURAL_LUBRICATION)
									? "your wet [pc.pussy] betraying your arousal."
									: "your [pc.pussy].")
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.pussy+] is revealed."
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
							+ "[npc.Name] tries to pull away from you as "
							+ (Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).contains(LubricationType.PLAYER_NATURAL_LUBRICATION)
									? "your wet [pc.pussy] is revealed."
									: "your [pc.pussy+] is revealed.")
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your [pc.pussy+] is revealed."
							+ "</p>";
			}
		}
	}

	public String getPlayerMoundRevealReaction(boolean isPlayerDom) {
		if(Sex.isConsensual()) {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return "<p>"
								+ "[npc.Name] lets out a soft [npc.moan] as your genderless mound is revealed."
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your genderless mound is revealed."
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] lets out a mocking laugh as your genderless mound is revealed."
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan+] as your genderless mound is revealed."
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your genderless mound is revealed."
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob+] as your genderless mound is revealed."
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as your genderless mound is revealed."
							+ "</p>";
			}
		} else if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
			return "<p>"
					+ "[npc.Name] lets out [npc.a_sob+] as your genderless mound is revealed, [npc.speech(Get away from me!)]"
				+ "</p>";
			
		} else {
			if(isFeminine()) {
				if (isPlayerDom) {
					return "<p>"
							+ "[npc.Name] looks confused for a moment before letting out a patronising sigh, "
							+ UtilText.parseSpeech("Awww... You're like a little doll down there! That's so cute!", Sex.getPartner())
							+ "</p>";
				} else {
					return "<p>"
							+ "[npc.Name] looks confused for a moment before breaking out into a mocking laugh, "
							+ UtilText.parseSpeech("Hahaha! You're like a little doll down there!", Sex.getPartner())
							+ "</p>";
				}
			// Masculine NPC:
			} else {
				if(isPlayerDom) {
					return "<p>"
							+ "[npc.Name] looks confused for a moment before letting out a patronising sneer, "
							+ UtilText.parseSpeech("Awww... You're like a little doll down there! That's so cute!", Sex.getPartner())
						+ "</p>";
				} else {
					return "<p>"
								+ "[npc.Name] looks confused for a moment before breaking out into a mocking laugh, "
								+ UtilText.parseSpeech("Hahaha! You're like a little doll down there!", Sex.getPartner())
							+ "</p>";
				}
			}
		}
	}

	// Partner area reveals:
	
	public String getPartnerAssRevealReaction(boolean isPlayerDom) {
		return "";
	}

	public String getPartnerBreastsRevealReaction(boolean isPlayerDom) {
		return "";
	}

	public String getPartnerPenisRevealReaction(boolean isPlayerDom) {
		if(this.getPlayerKnowsAreasMap().get(CoverableArea.PENIS) || !isFeminine()) {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
						return "<p>"
								+ "[npc.Name] lets out a soft [npc.moan] as [npc.her] [npc.cock+] is revealed."
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.cock+]."
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] grins as [npc.she] sees you staring at [npc.her] [npc.cock+]."
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.cock+]."
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as [npc.she] sees you staring at [npc.her] [npc.cock+]."
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob] and tries to pull away from you as [npc.her] [npc.cock+] is revealed."
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.cock+]."
							+ "</p>";
			}
			
		} else if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
			return "<p>"
					+ "[npc.Name] lets out [npc.a_sob] and tries to pull away from you as [npc.her] [npc.cock+] is revealed."
				+ "</p>";
			
		} else {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return "<p>"
								+ "[npc.Name] lets out a soft giggle as [npc.she] sees you staring at [npc.her] [npc.cock+],"
								+ " [npc.speech(Let's have some fun!)]"
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out a playful giggle as [npc.she] sees you staring at [npc.her] [npc.cock+],"
								+ " [npc.speech(That look on your face is priceless! Now let's have some fun!)]"
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] lets out a laugh as [npc.she] sees you staring at [npc.her] [npc.cock+],"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out a playful giggle as [npc.she] sees you staring at [npc.her] [npc.cock+],"
								+ " [npc.speech(That look on your face is priceless! Now let's have some fun!)]"
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as [npc.she] sees you staring at [npc.her] [npc.cock+],"
								+ " [npc.speech(Let's have some fun!)]"
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob] and tries to pull away from you as [npc.her] [npc.cock+] is revealed,"
								+ " [npc.speech(Leave me alone!)]"
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.cock+],"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
			}
		}
	}

	public String getPartnerVaginaRevealReaction(boolean isPlayerDom) {
		if(this.getPlayerKnowsAreasMap().get(CoverableArea.VAGINA) || isFeminine()) {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
						return "<p>"
								+ "[npc.Name] lets out a soft [npc.moan] as [npc.her] [npc.pussy+] is revealed."
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+]."
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] grins as [npc.she] sees you staring at [npc.her] [npc.pussy+]."
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+]."
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+]."
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob] and tries to pull away from you as [npc.her] [npc.pussy+] is revealed."
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+]."
							+ "</p>";
			}
			
		} else if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
			return "<p>"
					+ "[npc.Name] lets out [npc.a_sob] and tries to pull away from you as [npc.her] [npc.pussy+] is revealed."
				+ "</p>";
			
		} else {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return "<p>"
								+ "[npc.Name] lets out a soft [npc.moan] as [npc.her] [npc.pussy+] is revealed,"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
				case DOM_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+],"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
				case DOM_ROUGH:
					return "<p>"
								+ "[npc.Name] grins as [npc.she] sees you staring at [npc.her] [npc.pussy+],"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
				case SUB_EAGER:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+],"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
				case SUB_NORMAL:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+],"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
				case SUB_RESISTING:
					return "<p>"
								+ "[npc.Name] lets out [npc.a_sob] and tries to pull away from you as [npc.her] [npc.pussy+] is revealed,"
								+ " [npc.speech(Leave me alone!)]"
							+ "</p>";
				default:
					return "<p>"
								+ "[npc.Name] lets out an excited [npc.moan] as [npc.she] sees you staring at [npc.her] [npc.pussy+],"
								+ " [npc.speech(Hah! I bet you didn't expect this!)]"
							+ "</p>";
			}
		}
	}

	public String getPartnerMoundRevealReaction(boolean isPlayerDom) {
		return "";
	}

	// Penetrations:
	
	private String generateGenericPenetrationDescription(PenetrationType penetrationType, OrificeType orifice) {
		
		// Kissing:
		if(penetrationType == PenetrationType.TONGUE_PLAYER && orifice == OrificeType.MOUTH_PARTNER) {
			switch(Sex.getSexPacePlayer()) {
				case DOM_GENTLE:
					return UtilText.returnStringAtRandom(
							"Your soft [pc.moans] are muffled into [npc.name]'s mouth as you continue kissing [npc.herHim].",
							"You gently press your [pc.lips+] against [npc.name]'s as you continue kissing [npc.herHim].",
							"Gently pressing your [pc.lips+] against [npc.name]'s, you continue making out with [npc.herHim].");
				case DOM_NORMAL:
					return UtilText.returnStringAtRandom(
							"Your [pc.moans+] are muffled into [npc.name]'s mouth as you continue passionately kissing [npc.herHim].",
							"You eagerly press your [pc.lips+] against [npc.name]'s as you continue passionately kissing [npc.herHim].",
							"Passionately pressing your [pc.lips+] against [npc.name]'s, you continue making out with [npc.herHim].");
				case DOM_ROUGH:
					return UtilText.returnStringAtRandom(
							"Your [pc.moans+] are muffled into [npc.name]'s mouth as you continue forcefully snogging [npc.herHim].",
							"You roughly grind your [pc.lips+] against [npc.name]'s as you continue forcefully snogging [npc.herHim].",
							"Roughly grinding your [pc.lips+] against [npc.name]'s, you continue making out with [npc.herHim].");
				case SUB_EAGER:
					return UtilText.returnStringAtRandom(
							"Your [pc.moans+] are muffled into [npc.name]'s mouth as you continue passionately kissing [npc.herHim].",
							"You eagerly press your [pc.lips+] against [npc.name]'s as you continue passionately kissing [npc.herHim].",
							"Passionately pressing your [pc.lips+] against [npc.name]'s, you continue making out with [npc.herHim].");
				case SUB_NORMAL:
					return UtilText.returnStringAtRandom(
							"Your [pc.moans] are muffled into [npc.name]'s mouth as you continue kissing [npc.herHim].",
							"You press your [pc.lips+] against [npc.name]'s as you continue kissing [npc.herHim].",
							"Pressing your [pc.lips+] against [npc.name]'s, you continue making out with [npc.herHim].");
				case SUB_RESISTING:
					return UtilText.returnStringAtRandom(
							"Your [pc.sobs+] are muffled into [npc.name]'s mouth as you desperately try to push [npc.herHim] away from you.",
							"You try to pull your [pc.lips+] away from [npc.name]'s as you struggle against [npc.herHim].",
							"Trying to pull your [pc.lips+] away from [npc.name]'s, you continue struggling against [npc.her] unwanted kiss.");
			}
		}
		if(penetrationType == PenetrationType.TONGUE_PARTNER && orifice == OrificeType.MOUTH_PLAYER) {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					return UtilText.returnStringAtRandom(
							"[npc.Name]'s soft [npc.moans] are muffled into your mouth as [npc.she] continues kissing you.",
							"[npc.Name] gently presses [npc.her] [npc.lips+] against yours as [npc.she] continues kissing you.",
							"Gently pressing [npc.her] [npc.lips+] against yours, [npc.name] continues making out with you.");
				case DOM_NORMAL:
					return UtilText.returnStringAtRandom(
							"[npc.Name]'s [npc.moans+] are muffled into your mouth as [npc.she] continues passionately kissing you.",
							"[npc.Name] eagerly presses [npc.her] [npc.lips+] against yours as [npc.she] continues passionately kissing you.",
							"Passionately pressing [npc.her] [npc.lips+] against yours, [npc.name] continues making out with you.");
				case DOM_ROUGH:
					return UtilText.returnStringAtRandom(
							"[npc.Name]'s [npc.moans+] are muffled into your mouth as [npc.she] continues forcefully snogging you.",
							"[npc.Name] roughly grinds [npc.her] [npc.lips+] against yours as [npc.she] continues forcefully snogging you.",
							"Roughly grinding [npc.her] [npc.lips+] against yours, [npc.name] continues making out with you.");
				case SUB_EAGER:
					return UtilText.returnStringAtRandom(
							"[npc.Name]'s [npc.moans+] are muffled into your mouth as [npc.she] continues passionately kissing you.",
							"[npc.Name] eagerly presses [npc.her] [npc.lips+] against yours as [npc.she] continues passionately kissing you.",
							"Passionately pressing [npc.her] [npc.lips+] against yours, [npc.name] continues making out with you.");
				case SUB_NORMAL:
					return UtilText.returnStringAtRandom(
							"[npc.Name]'s [npc.moans] are muffled into your mouth as [npc.she] continues kissing you.",
							"[npc.Name] presses [npc.her] [npc.lips+] against yours as [npc.she] continues kissing you.",
							"Pressing [npc.her] [npc.lips+] against yours, [npc.name] continues making out with you.");
				case SUB_RESISTING:
					return UtilText.returnStringAtRandom(
							"[npc.Name]'s [npc.sobs+] are muffled into your mouth as [npc.she] desperately tries to push you away from [npc.herHim].",
							"[npc.Name] tries to pull [npc.her] [npc.lips+] away from yours as [npc.she] struggles against you.",
							"Trying to pull [npc.her] [npc.lips+] away from yours, [npc.name] continues struggling against your unwanted kiss.");
			}
		}
		
		String orificeName="", penetratorName="",
				subQualifier="", domQualifier="",
				subAction="", domAction="",
				subReactionPrefix="", domReactionPrefix="",
				subSelfReactionPrefix="", domSelfReactionPrefix="",
				subPenDomReactionPostfix="", domPenSubReactionPostfix="", subPenSelfReactionPostfix="", domPenSelfReactionPostfix="";
		
		switch(penetrationType) {
			case FINGER_PARTNER:
				penetratorName = "[npc.fingers]";
				break;
			case FINGER_PLAYER:
				penetratorName = "[pc.fingers]";
				break;
			case PENIS_PARTNER:
				penetratorName = "[npc.penis+]";
				break;
			case PENIS_PLAYER:
				penetratorName = "[pc.penis+]";
				break;
			case TAIL_PARTNER:
				penetratorName = "[npc.tail+]";
				break;
			case TAIL_PLAYER:
				penetratorName = "[pc.tail+]";
				break;
			case TENTACLE_PARTNER:
				break;
			case TENTACLE_PLAYER:
				break;
			case TONGUE_PARTNER:
				penetratorName = "[npc.tongue]";
				break;
			case TONGUE_PLAYER:
				penetratorName = "[pc.tongue]";
				break;
		}
		
		switch(orifice) {
			case ANUS_PARTNER:
				orificeName = "[npc.asshole+]";
				break;
			case ANUS_PLAYER:
				orificeName = "[pc.asshole+]";
				break;
			case MOUTH_PARTNER:
				orificeName = "mouth";
				break;
			case MOUTH_PLAYER:
				orificeName = "mouth";
				break;
			case NIPPLE_PARTNER:
				orificeName = "[npc.nipple+]";
				break;
			case NIPPLE_PLAYER:
				orificeName = "[pc.nipple+]";
				break;
			case URETHRA_PARTNER:
				break;
			case URETHRA_PLAYER:
				break;
			case VAGINA_PARTNER:
				orificeName = "[npc.pussy+]";
				break;
			case VAGINA_PLAYER:
				orificeName = "[pc.pussy+]";
				break;
			case BREAST_PARTNER:
				orificeName = "[npc.breasts+]";
				break;
			case BREAST_PLAYER:
				orificeName = "[pc.breasts+]";
				break;
		}
		
		if(Sex.isPlayerDom()) {
			if(Sex.getSexPacePlayer()==SexPace.DOM_GENTLE) {
				domQualifier = UtilText.returnStringAtRandom("gently", "slowly", "steadily");
				domAction = UtilText.returnStringAtRandom("slide", "pump", "thrust");
				domReactionPrefix = UtilText.returnStringAtRandom("You let out a soft [pc.moan]", "You make soothing noises", "A soft [pc.moan] drifts out from between your [pc.lips+]");
				domSelfReactionPrefix = UtilText.returnStringAtRandom("You let out a soft [pc.moan]", "You sigh and pant", "A soft [pc.moan] drifts out from between your [pc.lips+]");
				domPenSelfReactionPostfix = UtilText.returnStringAtRandom(
						" letting out a soft [pc.moan] as you do so",
						" driving a soft [pc.moan] from between your [pc.lips+]");
				
				if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
					subQualifier = UtilText.returnStringAtRandom("reluctantly", "half-heartedly", "hesitantly");
					subAction = UtilText.returnStringAtRandom("slides", "pushes", "drives");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] struggles and tries to protest", "[npc.Name] attempts to push you away", "[npc.Name] lets out a protesting whine");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] tries not to look at you", "[npc.Name] tries to shuffle away from you", "[npc.Name] fails to suppress a desperate whine");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" ignoring [npc.her] protests as you use [npc.her] body",
							" making soothing noises as you ignore [npc.her] protestations",
							" letting out a soft [pc.moan] as you ignore [npc.her] protests");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out a soft [pc.moan]",
							" trying [npc.herHis] hardest to ignore your delighted [pc.moans] as [npc.she] does so",
							" making protesting little whining noises as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" failing to suppress [npc.a_moan+] as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				} else if(Sex.getSexPacePartner()==SexPace.SUB_NORMAL) {
					subQualifier = UtilText.returnStringAtRandom(" ", " ", "happily", "willingly");
					subAction = UtilText.returnStringAtRandom("slides", "pushes", "drives", "thrusts", "pumps");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] grinds [npc.herself] against you", "[npc.A_moan+] escapes from between [npc.name]'s [npc.lips+]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] [npc.moansVerb+]", "[npc.Name] fails to suppress [npc.a_moan+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [pc.moans+]",
							" making soothing noises as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out a soft [pc.moan]",
							" letting out [npc.a_moan+] as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [npc.moaning] in delight as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				} else if(Sex.getSexPacePartner()==SexPace.SUB_EAGER) {
					subQualifier = UtilText.returnStringAtRandom("desperately", "frantically", "eagerly", "enthusiastically");
					subAction = UtilText.returnStringAtRandom("slams", "hammers", "thrusts", "pumps");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.A_moan+] bursts out from [npc.name]'s mouth", "[npc.Name] presses [npc.herself] against you", "[npc.A_moan+] bursts out from between [npc.name]'s [npc.lips+]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] [npc.moansVerb+]", "[npc.A_moan+] bursts out from between [npc.name]'s [npc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [pc.moans+]",
							" making soothing noises as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out a soft [pc.moan]",
							" letting out [npc.a_moan+] as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [npc.moaning] in delight as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				}
				
			} else if(Sex.getSexPacePlayer()==SexPace.DOM_NORMAL) {
				domQualifier = UtilText.returnStringAtRandom(" ", " ", "readily", "happily");
				domAction = UtilText.returnStringAtRandom("slide", "push", "drive", "thrust", "pump");
				domReactionPrefix = UtilText.returnStringAtRandom("You let out [pc.a_moan]", "[pc.A_moan+] escapes from between your [pc.lips+]", "You let out a series of [pc.moans+]");
				domSelfReactionPrefix = UtilText.returnStringAtRandom("You let out a [pc.moan]", "You [pc.moan] and pant", "You let out a series of [pc.moans+]");
				domPenSelfReactionPostfix = UtilText.returnStringAtRandom(
						" letting out [pc.a_moan+] as you do so",
						" driving out [pc.a_moan+] from between your [pc.lips+]");
				
				if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
					subQualifier = UtilText.returnStringAtRandom("reluctantly", "half-heartedly", "hesitantly");
					subAction = UtilText.returnStringAtRandom("slides", "pushes", "drives");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] struggles and tries to protest", "[npc.Name] attempts to push you away", "[npc.Name] lets out a protesting whine");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] tries not to look at you", "[npc.Name] tries to shuffle away from you", "[npc.Name] fails to suppress a desperate whine");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" ignoring [npc.her] protests as you use [npc.her] body",
							" letting out [pc.a_moan+] as you ignore [npc.her] protestations",
							" letting out [pc.a_moan+] as you ignore [npc.her] protests");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out [pc.a_moan+]",
							" trying [npc.herHis] hardest to ignore your [pc.moans+] as [npc.she] does so",
							" making protesting little whining noises as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" failing to suppress [npc.a_moan+] as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				} else if(Sex.getSexPacePartner()==SexPace.SUB_NORMAL) {
					subQualifier = UtilText.returnStringAtRandom(" ", " ", "happily", "willingly");
					subAction = UtilText.returnStringAtRandom("slides", "pushes", "drives", "thrusts", "pumps");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] grinds [npc.herself] against you", "[npc.A_moan+] escapes from between [npc.name]'s [npc.lips+]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] [npc.moansVerb+]", "[npc.Name] fails to suppress [npc.a_moan+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [pc.moans+]",
							" letting out a series of [pc.moans+] as you do so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out [pc.a_moan+]",
							" letting out [npc.a_moan+] as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [npc.moaning] in delight as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				} else if(Sex.getSexPacePartner()==SexPace.SUB_EAGER) {
					subQualifier = UtilText.returnStringAtRandom("desperately", "frantically", "eagerly", "enthusiastically");
					subAction = UtilText.returnStringAtRandom("slams", "hammers", "thrusts", "pumps");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.A_moan+] bursts out from [npc.name]'s mouth", "[npc.Name] presses [npc.herself] against you", "[npc.A_moan+] bursts out from between [npc.name]'s [npc.lips+]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] [npc.moansVerb+]", "[npc.A_moan+] bursts out from between [npc.name]'s [npc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [pc.moans+]",
							" making soothing noises as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out a soft [pc.moan]",
							" letting out [npc.a_moan+] as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [npc.moaning] in delight as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				}
				
			} else if(Sex.getSexPacePlayer()==SexPace.DOM_ROUGH) {
				domQualifier = UtilText.returnStringAtRandom("roughly", "forcefully", "mercilessly");
				domAction = UtilText.returnStringAtRandom("slam", "hammer", "thrust", "pump", "piston");
				domReactionPrefix = UtilText.returnStringAtRandom("You let out a [pc.moan]", "[pc.A_moan+] escapes from between your [pc.lips+]", "You let out a series of [pc.moans+]");
				domSelfReactionPrefix = UtilText.returnStringAtRandom("You let out a [pc.moan]", "You [pc.moan] and pant", "You let out a series of [pc.moans+]");
				domPenSelfReactionPostfix = UtilText.returnStringAtRandom(
						" letting out [pc.a_moan+] as you do so",
						" driving out [pc.a_moan+] from between your [pc.lips+]");
				
				if(Sex.getSexPacePartner()==SexPace.SUB_RESISTING) {
					subQualifier = UtilText.returnStringAtRandom("reluctantly", "half-heartedly", "hesitantly");
					subAction = UtilText.returnStringAtRandom("slides", "pushes", "drives");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] struggles and tries to protest", "[npc.Name] attempts to push you away", "[npc.Name] lets out a protesting whine");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] tries not to look at you", "[npc.Name] tries to shuffle away from you", "[npc.Name] fails to suppress a desperate whine");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" telling [npc.herHim] to stop resisting as you use [npc.her] body",
							" letting out [pc.a_moan+] as you tell [npc.herHim] to stop protesting",
							" letting out [pc.a_moan+] as you growl at [npc.herHim] to stop [npc.her] protests");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out [pc.a_moan+]",
							" trying [npc.herHis] hardest to ignore your rough treatment as [npc.she] does so",
							" making protesting little whining noises as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" failing to suppress [npc.a_moan+] as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				} else if(Sex.getSexPacePartner()==SexPace.SUB_NORMAL) {
					subQualifier = UtilText.returnStringAtRandom(" ", " ", "happily", "willingly");
					subAction = UtilText.returnStringAtRandom("slides", "pushes", "drives", "thrusts", "pumps");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] grinds [npc.herself] against you", "[npc.A_moan+] escapes from between [npc.name]'s [npc.lips+]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] [npc.moansVerb+]", "[npc.Name] fails to suppress [npc.a_moan+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [pc.moans+]",
							" letting out a series of [pc.moans+] as you do so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out [pc.a_moan+]",
							" letting out [npc.a_moan+] as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [npc.moaning] in delight as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				} else if(Sex.getSexPacePartner()==SexPace.SUB_EAGER) {
					subQualifier = UtilText.returnStringAtRandom("desperately", "frantically", "eagerly", "enthusiastically");
					subAction = UtilText.returnStringAtRandom("slams", "hammers", "thrusts", "pumps");
					subReactionPrefix = UtilText.returnStringAtRandom("[npc.A_moan+] bursts out from [npc.name]'s mouth", "[npc.Name] presses [npc.herself] against you", "[npc.A_moan+] bursts out from between [npc.name]'s [npc.lips+]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan+]", "[npc.Name] [npc.moansVerb+]", "[npc.A_moan+] bursts out from between [npc.name]'s [npc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [pc.moans+]",
							" letting out a series of [pc.moans+] as you do so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing you to let out a soft [pc.moan]",
							" letting out [npc.a_moan+] as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [npc.moaning] in delight as [npc.she] does so",
							" letting out [npc.a_moan+] as [npc.she] does so");
					
				}
			}
			
			if(domQualifier.length()>1) {
				domQualifier = " "+domQualifier;
			} else {
				domQualifier = "";
			}
			
			if(subQualifier.length()>1) {
				subQualifier = " "+subQualifier;
			} else {
				subQualifier = "";
			}
			
			// PC (dom) penetrating NPC (sub):
			if(penetrationType.isPlayer() && !orifice.isPlayer()) {
				return UtilText.returnStringAtRandom(
						subReactionPrefix+" as you"+domQualifier+" "+domAction+" your "+penetratorName+" in and out of [npc.her] "+orificeName+".",
						subReactionPrefix+" as you"+domQualifier+" "+domAction+" your "+penetratorName+" deep into [npc.her] "+orificeName+".",
						"You"+domQualifier+" "+domAction+" your "+penetratorName+" deep into [npc.name]'s "+orificeName+", "+domPenSubReactionPostfix+".",
						"You"+domQualifier+" "+domAction+" your "+penetratorName+" in and out of [npc.name]'s "+orificeName+", "+domPenSubReactionPostfix+".");
				
			// NPC (sub) penetrating PC (dom):
			} else if(!penetrationType.isPlayer() && orifice.isPlayer()) {
				return UtilText.returnStringAtRandom(
						domReactionPrefix+" as [npc.name]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" in and out of your "+orificeName+".",
						domReactionPrefix+" as [npc.name]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" deep into your "+orificeName+".",
						"[npc.Name]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" deep into your "+orificeName+", "+subPenDomReactionPostfix+".",
						"[npc.Name]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" in and out of your "+orificeName+", "+subPenDomReactionPostfix+".");
				
			// PC (dom) self-penetrating:
			} else if(penetrationType.isPlayer() && orifice.isPlayer()) {
				return UtilText.returnStringAtRandom(
						domSelfReactionPrefix+" as you"+domQualifier+" "+domAction+" your "+penetratorName+" in and out of your "+orificeName+".",
						domSelfReactionPrefix+" as you"+domQualifier+" "+domAction+" your "+penetratorName+" deep into your "+orificeName+".",
						"You"+domQualifier+" "+domAction+" your "+penetratorName+" deep into your "+orificeName+", "+domPenSelfReactionPostfix+".",
						"You"+domQualifier+" "+domAction+" your "+penetratorName+" in and out of your "+orificeName+", "+domPenSelfReactionPostfix+".");
				
			// NPC (sub) self-penetrating:
			} else {
				return UtilText.returnStringAtRandom(
						subSelfReactionPrefix+" as [npc.she]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" in and out of [npc.her] "+orificeName+".",
						subSelfReactionPrefix+" as [npc.she]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" deep into [npc.her] "+orificeName+".",
						"[npc.Name]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" deep into [npc.her] "+orificeName+", "+subPenSelfReactionPostfix+".",
						"[npc.Name]"+subQualifier+" "+subAction+" [npc.her] "+penetratorName+" in and out of [npc.her] "+orificeName+", "+subPenSelfReactionPostfix+".");
			}
			
			
		} else { // Player is sub:
			
			if(Sex.getSexPacePartner()==SexPace.DOM_GENTLE) {
				domQualifier = UtilText.returnStringAtRandom("gently", "slowly", "steadily");
				domAction = UtilText.returnStringAtRandom("slides", "pumps", "thrusts");
				domReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out a soft [pc.moan]", "[npc.Name] makes soothing noises", "A soft [npc.moan] drifts out from between [npc.name]'s [npc.lips+]");
				domSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out a soft [pc.moan]", "[npc.Name] [npc.moansVerb+]", "A soft [npc.moan] drifts out from between [npc.name]'s [npc.lips+]");
				domPenSelfReactionPostfix = UtilText.returnStringAtRandom(
						" letting out a soft [npc.moan] as [npc.she] does so",
						" driving a soft [npc.moan] from between [npc.her] [npc.lips+]");
				
				if(Sex.getSexPacePlayer()==SexPace.SUB_RESISTING) {
					subQualifier = UtilText.returnStringAtRandom("reluctantly", "half-heartedly", "hesitantly");
					subAction = UtilText.returnStringAtRandom("slide", "push", "drive");
					subReactionPrefix = UtilText.returnStringAtRandom("You struggle and try to protest as [npc.name]", "You try to pull away as [npc.name]", "You let out a protesting whine as [npc.name]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("You try not to look at [npc.name]", "You try to shuffle away from [npc.name]", "You fail to suppress a desperate whine");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" ignoring your protests as [npc.she] uses your body",
							" making soothing noises as [npc.she] ignores your protestations",
							" letting out a soft [npc.moan] as [npc.she] ignores your protests");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [npc.herHim] to let out a soft [npc.moan]",
							" trying your hardest to ignore [npc.her] delighted [npc.moans] as you do so",
							" making protesting little whining noises as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" failing to suppress [pc.a_moan+] as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				} else if(Sex.getSexPacePlayer()==SexPace.SUB_NORMAL) {
					subQualifier = UtilText.returnStringAtRandom(" ", " ", "happily", "willingly");
					subAction = UtilText.returnStringAtRandom("slide", "push", "drive", "thrust", "pump");
					subReactionPrefix = UtilText.returnStringAtRandom("You let out [pc.a_moan+] as [npc.name]", "You grind yourself against [npc.name] as", "[pc.A_moan+] escapes from between your [pc.lips+] as [npc.name]");
					subSelfReactionPrefix  = UtilText.returnStringAtRandom("You let out [pc.a_moan+]", "You press yourself against [npc.name]", "[pc.A_moan+] escapes from between your [pc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [npc.moans+]",
							" making soothing noises as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [pc.herHim] to let out a soft [npc.moan]",
							" letting out [pc.a_moan+] as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [pc.moaning] in delight as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				} else if(Sex.getSexPacePlayer()==SexPace.SUB_EAGER) {
					subQualifier = UtilText.returnStringAtRandom("desperately", "frantically", "eagerly", "enthusiastically");
					subAction = UtilText.returnStringAtRandom("slam", "hammer", "thrust", "pump");
					subReactionPrefix = UtilText.returnStringAtRandom("[pc.A_moan+] bursts out from your mouth as [npc.name]", "You press yourself against [npc.name] as", "[pc.A_moan+] bursts out from between your [pc.lips+] as [npc.name]");
					subSelfReactionPrefix  = UtilText.returnStringAtRandom("[pc.A_moan+] bursts out from your mouth", "You press yourself against [npc.name]", "[pc.A_moan+] bursts out from between your [pc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [npc.moans+]",
							" making soothing noises as [npc.she] does so",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [pc.herHim] to let out a soft [npc.moan]",
							" letting out [pc.a_moan+] as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [pc.moaning] in delight as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				}
				
			} else if(Sex.getSexPacePartner()==SexPace.DOM_NORMAL) {
				domQualifier = UtilText.returnStringAtRandom(" ", " ", "readily", "happily");
				domAction = UtilText.returnStringAtRandom("slides", "pushes", "drives", "thrusts", "pumps");
				domReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan]", "[npc.A_moan+] escapes from between [npc.name]'s [npc.lips+]", "[npc.Name] lets out a series of [npc.moans+]");
				domSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [pc.a_moan+]", "[npc.A_moan+] escapes from between [npc.name]'s [npc.lips+]", "[npc.Name] lets out a series of [npc.moans+]");
				domPenSelfReactionPostfix = UtilText.returnStringAtRandom(
						" letting out [npc.a_moan+] as [npc.she] does so",
						" driving out [npc.a_moan+] from between [npc.her] [npc.lips+]");
				
				if(Sex.getSexPacePlayer()==SexPace.SUB_RESISTING) {
					subQualifier = UtilText.returnStringAtRandom("reluctantly", "half-heartedly", "hesitantly");
					subAction = UtilText.returnStringAtRandom("slides", "pushes", "drives");
					subReactionPrefix = UtilText.returnStringAtRandom("You struggle and try to protest as [npc.name]", "You try to pull away as [npc.name]", "You let out a protesting whine as [npc.name]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("You try not to look at [npc.name]", "You try to shuffle away from [npc.name]", "You fail to suppress a desperate whine");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" ignoring your protests as [npc.she] uses your body",
							" letting out [npc.a_moan+] as [npc.she] ignores your protestations",
							" letting out [npc.a_moan+] as [npc.she] ignores your protests");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [npc.herHim] to let out [npc.a_moan+]",
							" trying your hardest to ignore [npc.her] [npc.moans+] as you do so",
							" making protesting little whining noises as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" failing to suppress [pc.a_moan+] as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				} else if(Sex.getSexPacePlayer()==SexPace.SUB_NORMAL) {
					subQualifier = UtilText.returnStringAtRandom(" ", " ", "happily", "willingly");
					subAction = UtilText.returnStringAtRandom("slide", "push", "drive", "thrust", "pump");
					subReactionPrefix = UtilText.returnStringAtRandom("You let out [pc.a_moan+] as [npc.name]", "You grind yourself against [npc.name] as", "[pc.A_moan+] escapes from between your [pc.lips+] as [npc.name]");
					subSelfReactionPrefix  = UtilText.returnStringAtRandom("You let out [pc.a_moan+]", "You press yourself against [npc.name]", "[pc.A_moan+] escapes from between your [pc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [npc.moans+]",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [npc.herHim] to let out [npc.a_moan+]",
							" letting out [pc.a_moan+] as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [pc.moaning] in delight as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				} else if(Sex.getSexPacePlayer()==SexPace.SUB_EAGER) {
					subQualifier = UtilText.returnStringAtRandom("desperately", "frantically", "eagerly", "enthusiastically");
					subAction = UtilText.returnStringAtRandom("slam", "hammer", "thrust", "pump");
					subReactionPrefix = UtilText.returnStringAtRandom("[pc.A_moan+] bursts out from your mouth as [npc.name]", "You press yourself against [npc.name] as", "[pc.A_moan+] bursts out from between your [pc.lips+] as [npc.name]");
					subSelfReactionPrefix  = UtilText.returnStringAtRandom("[pc.A_moan+] bursts out from your mouth", "You press yourself against [npc.name]", "[pc.A_moan+] bursts out from between your [pc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [npc.moans+]",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [npc.herHim] to let out [npc.a_moan+]",
							" letting out [pc.a_moan+] as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [pc.moaning] in delight as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				}
				
			} else if(Sex.getSexPacePartner()==SexPace.DOM_ROUGH) {
				domQualifier = UtilText.returnStringAtRandom("roughly", "forcefully", "mercilessly");
				domAction = UtilText.returnStringAtRandom("slams", "hammers", "thrusts", "pumps", "pistons");
				domReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [npc.a_moan]", "[npc.A_moan+] escapes from between [npc.name]'s [npc.lips+]", "[npc.Name] lets out a series of [npc.moans+]");
				domSelfReactionPrefix = UtilText.returnStringAtRandom("[npc.Name] lets out [pc.a_moan+]", "[npc.A_moan+] escapes from between [npc.name]'s [npc.lips+]", "[npc.Name] lets out a series of [npc.moans+]");
				domPenSelfReactionPostfix = UtilText.returnStringAtRandom(
						" letting out [npc.a_moan+] as [npc.she] does so",
						" driving out [npc.a_moan+] from between [npc.her] [npc.lips+]");
				
				if(Sex.getSexPacePlayer()==SexPace.SUB_RESISTING) {
					subQualifier = UtilText.returnStringAtRandom("reluctantly", "half-heartedly", "hesitantly");
					subAction = UtilText.returnStringAtRandom("slide", "pushes", "drive");
					subReactionPrefix = UtilText.returnStringAtRandom("You struggle and try to protest as [npc.name]", "You try to pull away as [npc.name]", "You let out a protesting whine as [npc.name]");
					subSelfReactionPrefix = UtilText.returnStringAtRandom("You try not to look at [npc.name]", "You try to shuffle away from [npc.name]", "You fail to suppress a desperate whine");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" telling you to stop resisting as [npc.she] uses your body",
							" letting out [npc.a_moan+] as [npc.she] tells you to stop protesting",
							" letting out [npc.a_moan+] as [npc.she] growls at you to stop your protests");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [npc.herHim] to let out [npc.a_moan+]",
							" trying your hardest to ignore [npc.her] rough treatment as you do so",
							" making protesting little whining noises as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" failing to suppress [pc.a_moan+] as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				} else if(Sex.getSexPacePlayer()==SexPace.SUB_NORMAL) {
					subQualifier = UtilText.returnStringAtRandom(" ", " ", "happily", "willingly");
					subAction = UtilText.returnStringAtRandom("slide", "push", "drive", "thrust", "pump");
					subReactionPrefix = UtilText.returnStringAtRandom("You let out [pc.a_moan+] as [npc.name]", "You grind yourself against [npc.name] as", "[pc.A_moan+] escapes from between your [pc.lips+] as [npc.name]");
					subSelfReactionPrefix  = UtilText.returnStringAtRandom("You let out [pc.a_moan+]", "You press yourself against [npc.name]", "[pc.A_moan+] escapes from between your [pc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [npc.moans+]",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [npc.herHim] to let out [npc.a_moan+]",
							" letting out [pc.a_moan+] as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [pc.moaning] in delight as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				} else if(Sex.getSexPacePlayer()==SexPace.SUB_EAGER) {
					subQualifier = UtilText.returnStringAtRandom("desperately", "frantically", "eagerly", "enthusiastically");
					subAction = UtilText.returnStringAtRandom("slam", "hammer", "thrust", "pump");
					subReactionPrefix = UtilText.returnStringAtRandom("[pc.A_moan+] bursts out from your mouth as [npc.name]", "You press yourself against [npc.name] as", "[pc.A_moan+] bursts out from between your [pc.lips+] as [npc.name]");
					subSelfReactionPrefix  = UtilText.returnStringAtRandom("[pc.A_moan+] bursts out from your mouth", "You press yourself against [npc.name]", "[pc.A_moan+] bursts out from between your [pc.lips+]");
					domPenSubReactionPostfix = UtilText.returnStringAtRandom(
							" letting out a series of [npc.moans+]",
							" letting out a series of [npc.moans+] as [npc.she] does so");
					subPenDomReactionPostfix = UtilText.returnStringAtRandom(
							" causing [npc.herHim] to let out [npc.a_moan+]",
							" letting out [pc.a_moan+] as you do so",
							" letting out a series of [pc.moans+] as you do so");
					subPenSelfReactionPostfix = UtilText.returnStringAtRandom(
							" [pc.moaning] in delight as you do so",
							" letting out [pc.a_moan+] as you do so");
					
				}
			}
			
			if(domQualifier.length()>1) {
				domQualifier = " "+domQualifier;
			} else {
				domQualifier = "";
			}
			
			if(subQualifier.length()>1) {
				subQualifier = " "+subQualifier;
			} else {
				subQualifier = "";
			}
			
			// NPC (dom) penetrating PC (sub):
			if(!penetrationType.isPlayer() && orifice.isPlayer()) {
				return UtilText.returnStringAtRandom(
						subReactionPrefix+" "+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" in and out of your "+orificeName+".",
						subReactionPrefix+" "+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" deep into your "+orificeName+".",
						"[npc.Name]"+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" deep into your "+orificeName+", "+domPenSubReactionPostfix+".",
						"[npc.Name]"+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" in and out of your "+orificeName+", "+domPenSubReactionPostfix+".");
				
			// PC (sub) penetrating NPC (dom):
			} else if(penetrationType.isPlayer() && !orifice.isPlayer()) {
				return UtilText.returnStringAtRandom(
						domReactionPrefix+" as you"+subQualifier+" "+subAction+" your "+penetratorName+" in and out of [npc.her] "+orificeName+".",
						domReactionPrefix+" as you"+subQualifier+" "+subAction+" your "+penetratorName+" deep into [npc.her] "+orificeName+".",
						"You"+subQualifier+" "+subAction+" your "+penetratorName+" deep into [npc.her] "+orificeName+", "+subPenDomReactionPostfix+".",
						"You"+subQualifier+" "+subAction+" your "+penetratorName+" in and out of [npc.her] "+orificeName+", "+subPenDomReactionPostfix+".");
				
			// NPC (dom) self-penetrating:
			} else if(!penetrationType.isPlayer() && !orifice.isPlayer()) {
				return UtilText.returnStringAtRandom(
						domSelfReactionPrefix+" as [npc.she]"+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" in and out of [npc.her] "+orificeName+".",
						domSelfReactionPrefix+" as [npc.she]"+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" deep into [npc.her] "+orificeName+".",
						"[npc.Name]"+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" deep into [npc.her] "+orificeName+", "+domPenSelfReactionPostfix+".",
						"[npc.Name]"+domQualifier+" "+domAction+" [npc.her] "+penetratorName+" in and out of [npc.her] "+orificeName+", "+domPenSelfReactionPostfix+".");
				
			// PC (sub) self-penetrating:
			} else {
				return UtilText.returnStringAtRandom(
						subSelfReactionPrefix+" as you"+subQualifier+" "+subAction+" your "+penetratorName+" in and out of your "+orificeName+".",
						subSelfReactionPrefix+" as you"+subQualifier+" "+subAction+" your "+penetratorName+" deep into your "+orificeName+".",
						"You"+subQualifier+" "+subAction+" your "+penetratorName+" deep into your "+orificeName+", "+subPenSelfReactionPostfix+".",
						"You"+subQualifier+" "+subAction+" your "+penetratorName+" in and out of your "+orificeName+", "+subPenSelfReactionPostfix+".");
			}
		}
		
	}
	
	public String getPenetrationDescription(boolean initialPenetration, PenetrationType penetrationType, OrificeType orifice) {
		String penetrationVerb=" slides", penetrationAdverb="";
		
		if(penetrationType.isPlayer()) {
			switch(Sex.getSexPacePlayer()) {
				case DOM_GENTLE:
					penetrationAdverb = UtilText.returnStringAtRandom(" slowly", " gently");
					penetrationVerb = UtilText.returnStringAtRandom(" slide", " push", " glide");
					break;
				case DOM_NORMAL:
					penetrationAdverb = "";
					penetrationVerb = UtilText.returnStringAtRandom(" push");
					break;
				case DOM_ROUGH:
					penetrationAdverb = UtilText.returnStringAtRandom(" roughly", " violently", " forcefully");
					penetrationVerb = UtilText.returnStringAtRandom(" slam", " grind");
					break;
				case SUB_EAGER:
					penetrationAdverb = UtilText.returnStringAtRandom(" eagerly", " desperately", " enthusiastically");
					penetrationVerb = UtilText.returnStringAtRandom(" slam", " grind");
					break;
				case SUB_NORMAL:
					penetrationAdverb = "";
					penetrationVerb = UtilText.returnStringAtRandom(" pushes");
					penetrationVerb = UtilText.returnStringAtRandom(" push");
					break;
				case SUB_RESISTING:
					penetrationAdverb = UtilText.returnStringAtRandom(" reluctantly", " hesitantly");
					penetrationVerb = UtilText.returnStringAtRandom(" push");
					break;
			}
		} else {
			switch(Sex.getSexPacePartner()) {
				case DOM_GENTLE:
					penetrationAdverb = UtilText.returnStringAtRandom(" slowly", " gently");
					penetrationVerb = UtilText.returnStringAtRandom(" slides", " pushes", " glides");
					break;
				case DOM_NORMAL:
					penetrationAdverb = "";
					penetrationVerb = UtilText.returnStringAtRandom(" pushes");
					break;
				case DOM_ROUGH:
					penetrationAdverb = UtilText.returnStringAtRandom(" roughly", " violently", " forcefully");
					penetrationVerb = UtilText.returnStringAtRandom(" slams", " grinds");
					break;
				case SUB_EAGER:
					penetrationAdverb = UtilText.returnStringAtRandom(" eagerly", " desperately", " enthusiastically");
					penetrationVerb = UtilText.returnStringAtRandom(" slams", " grinds");
					break;
				case SUB_NORMAL:
					penetrationAdverb = "";
					penetrationVerb = UtilText.returnStringAtRandom(" pushes");
					break;
				case SUB_RESISTING:
					penetrationAdverb = UtilText.returnStringAtRandom(" reluctantly", " hesitantly");
					penetrationVerb = UtilText.returnStringAtRandom(" pushes");
					break;
			}
		}
		
		
		if(orifice == OrificeType.ANUS_PLAYER) {
		
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PARTNER:
						switch(getPenisType()){
							case ANGEL:
								break;
							case AVIAN:
								break;
							case BOVINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s cow-like cock push into your [pc.asshole+].";
							case CANINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s dog-like cock push into your [pc.asshole+].";
							case LUPINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s wolf-like cock push into your [pc.asshole+].";
							case SQUIRREL:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s squirrel-like cock push into your [pc.asshole+].";
							case DEMON_COMMON:
								return "You let out [pc.a_moan+] as you feel the little bumps lining [npc.name]'s demonic cock wriggling against the walls of your [pc.asshole] as [npc.she] penetrates you.";
							case EQUINE:
								return "You let out [pc.a_moan+] as you feel the flared head of [npc.name]'s horse-like cock push into your [pc.asshole+].";
							case FELINE:
								return "You let out [pc.a_moan+] as you feel the barbs lining [npc.name]'s cat-like cock rake the walls of your [pc.asshole+] as [npc.she] starts to pull back.";
							case HUMAN:
								break;
							case NONE:
								break;
							case SLIME:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
		
		} else if(orifice == OrificeType.ANUS_PARTNER) {
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PLAYER:
						switch(getAssType()){
							case DEMON_COMMON:
								return "As the [pc.cockHead+] of your [pc.cock+] pushes its way into [npc.name]'s demonic, pussy-like [npc.asshole],"
										+ " you feel a series of little writhing tentacles start to massage and stroke your throbbing length.";
							default:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
			
		} else if(orifice == OrificeType.VAGINA_PLAYER) {
			
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PARTNER:
						switch(getPenisType()){
							case ANGEL:
								break;
							case AVIAN:
								break;
							case BOVINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s cow-like cock push into your [pc.pussy+].";
							case CANINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s dog-like cock push into your [pc.pussy+].";
							case LUPINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s wolf-like cock push into your [pc.pussy+].";
							case SQUIRREL:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s squirrel-like cock push into your [pc.pussy+].";
							case DEMON_COMMON:
								return "You let out [pc.a_moan+] as you feel the little bumps lining [npc.name]'s demonic cock wriggling against the walls of your [pc.pussy] as [npc.she] penetrates you.";
							case EQUINE:
								return "You let out [pc.a_moan+] as you feel the flared head of [npc.name]'s horse-like cock push into your [pc.pussy+].";
							case FELINE:
								return "You let out [pc.a_moan+] as you feel the barbs lining [npc.name]'s cat-like cock rake the walls of your [pc.pussy+] as [npc.she] starts to pull back.";
							case HUMAN:
								break;
							case NONE:
								break;
							case SLIME:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
			
		} else if(orifice == OrificeType.VAGINA_PARTNER) {
			
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PLAYER:
						switch(getVaginaType()){
							case DEMON_COMMON:
								return "As the [pc.cockHead+] of your [pc.cock+] pushes its way into [npc.name]'s demonic [npc.pussy], you feel a series of little writhing tentacles start to massage and stroke your throbbing length.";
							default:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
			
		} else if(orifice == OrificeType.NIPPLE_PLAYER) {
			
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PARTNER:
						switch(getPenisType()){
							case ANGEL:
								break;
							case AVIAN:
								break;
							case BOVINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s cow-like cock push into your [pc.nipple+].";
							case CANINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s dog-like cock push into your [pc.nipple+].";
							case LUPINE:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s wolf-like cock push into your [pc.nipple+].";
							case SQUIRREL:
								return "You let out [pc.a_moan+] as you feel [npc.name]'s squirrel-like cock push into your [pc.nipple+].";
							case DEMON_COMMON:
								return "You let out [pc.a_moan+] as you feel the little bumps lining [npc.name]'s demonic cock wriggling against the walls of your fuckable [pc.nipple] as [npc.she] penetrates you.";
							case EQUINE:
								return "You let out [pc.a_moan+] as you feel the flared head of [npc.name]'s horse-like cock push into your [pc.nipple+].";
							case FELINE:
								return "You let out [pc.a_moan+] as you feel the barbs lining [npc.name]'s cat-like cock rake the walls of your [pc.nipple+] as [npc.she] starts to pull back.";
							case HUMAN:
								break;
							case NONE:
								break;
							case SLIME:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
			
		} else if(orifice == OrificeType.NIPPLE_PARTNER) {
			
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PLAYER:
						switch(getBreastType()){
							case DEMON_COMMON:
								return "As the [pc.cockHead+] of your [pc.cock+] pushes its way into [npc.name]'s [npc.nipples+], you feel a series of little writhing tentacles start to massage and stroke your throbbing length.";
							default:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
			
		} else if(orifice == OrificeType.MOUTH_PLAYER) {
			
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PARTNER:
						switch(getPenisType()){
							case ANGEL:
								break;
							case AVIAN:
								break;
							case BOVINE:
								return "You let out a muffled [pc.moan] as [npc.name]'s cow-like cock pushes its way into your mouth.";
							case CANINE:
								return "You let out a muffled [pc.moan] as [npc.name]'s dog-like cock pushes its way into your mouth.";
							case LUPINE:
								return "You let out a muffled [pc.moan] as [npc.name]'s wolf-like cock pushes its way into your mouth.";
							case SQUIRREL:
								return "You let out a muffled [pc.moan] as [npc.name]'s squirrel-like cock pushes its way into your mouth.";
							case DEMON_COMMON:
								return "You let out a muffled [pc.moan] as you feel the little bumps lining [npc.name]'s demonic cock wriggling against your [pc.tongue+] as you start sucking [npc.herHim] off.";
							case EQUINE:
								return "You let out a muffled [pc.moan] as you feel the flared head of [npc.name]'s horse-like cock push its way into your mouth.";
							case FELINE:
								return "You let out a muffled [pc.moan] as you feel the barbs lining [npc.name]'s cat-like cock rake over your [pc.tongue] as [npc.she] starts to pull back.";
							case HUMAN:
								break;
							case NONE:
								break;
							case SLIME:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
			
		} else if(orifice == OrificeType.MOUTH_PARTNER) {
			if(penetrationType!=PenetrationType.TONGUE_PLAYER) {
				this.getPlayerKnowsAreasMap().put(CoverableArea.MOUTH, true);
			}
			
			if(initialPenetration) {
				switch(penetrationType) {
					case PENIS_PLAYER:
						switch(Main.game.getPlayer().getPenisType()){
							case ANGEL:
								break;
							case AVIAN:
								break;
							case BOVINE:
								return "[npc.Name] lets out a muffled [npc.moan] as your cow-like cock pushes its way into [npc.her] mouth.";
							case CANINE:
								return "[npc.Name] lets out a muffled [npc.moan] as your dog-like cock pushes its way into [npc.her] mouth.";
							case LUPINE:
								return "[npc.Name] lets out a muffled [npc.moan] as your wolf-like cock pushes its way into [npc.her] mouth.";
							case SQUIRREL:
								return "[npc.Name] lets out a muffled [npc.moan] as your squirrel-like cock pushes its way into [npc.her] mouth.";
							case DEMON_COMMON:
								return "[npc.Name] lets out a muffled [npc.moan] as [npc.she] feels the little bumps lining your demonic cock wriggling against [npc.her] [npc.tongue+] as [npc.she] starts sucking you off.";
							case EQUINE:
								return "[npc.Name] lets out a muffled [npc.moan] as [npc.she] feels the flared head of your horse-like cock push its way into [npc.her] mouth.";
							case FELINE:
								return "[npc.Name] lets out a muffled [npc.moan] as [npc.she] feels the barbs lining your cat-like cock rake over [npc.her] [npc.tongue] as you start to thrust in and out of [npc.her] mouth.";
							case HUMAN:
								break;
							case NONE:
								break;
							case SLIME:
								break;
						}
						break;
					
					default:
						break;
				}
				if(penetrationType.isPlayer()) {
					return "You let out [pc.a_moan+] as you"+penetrationAdverb+penetrationVerb+" your "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.name]'s ")+orifice.getName()+".";
				} else {
					return "[npc.Name] lets out [npc.a_moan+] as [npc.she]"+penetrationAdverb+penetrationVerb+" [npc.her] "+penetrationType.getName()+" into "+(orifice.isPlayer()?"your ":"[npc.her] ")+orifice.getName()+".";
				}
				
			}
			
			return generateGenericPenetrationDescription(penetrationType, orifice);
			
		}
		
		return "";
	}
	
	public String getStopPenetrationDescription(PenetrationType penetrationType, OrificeType orifice) {
		String orificeName = "", penetrationName = "";
		
		switch(orifice) {
			case ANUS_PARTNER:
				orificeName = "[npc.asshole+]";
				break;
			case ANUS_PLAYER:
				orificeName = "[pc.asshole+]";
				break;
			case MOUTH_PARTNER:
				orificeName = "mouth";
				break;
			case MOUTH_PLAYER:
				orificeName = "mouth";
				break;
			case NIPPLE_PARTNER:
				orificeName = "[npc.nipple+]";
				break;
			case NIPPLE_PLAYER:
				orificeName = "[pc.nipple+]";
				break;
			case URETHRA_PARTNER:
				orificeName = "urethra";
				break;
			case URETHRA_PLAYER:
				orificeName = "urethra";
				break;
			case VAGINA_PARTNER:
				orificeName = "[npc.pussy+]";
				break;
			case VAGINA_PLAYER:
				orificeName = "[pc.pussy+]";
				break;
			case BREAST_PARTNER:
				orificeName = "[npc.breasts+]";
				break;
			case BREAST_PLAYER:
				orificeName = "[pc.breasts+]";
				break;
		}
		
		switch(penetrationType) {
			case FINGER_PARTNER:
				penetrationName = "[npc.fingers]";
				break;
			case FINGER_PLAYER:
				penetrationName = "[pc.fingers]";
				break;
			case PENIS_PARTNER:
				penetrationName = "[npc.cock+]";
				break;
			case PENIS_PLAYER:
				penetrationName = "[pc.cock+]";
				break;
			case TAIL_PARTNER:
				penetrationName = "[npc.tail+]";
				break;
			case TAIL_PLAYER:
				penetrationName = "[pc.tail+]";
				break;
			case TENTACLE_PARTNER:
				penetrationName = "tentacle";
				break;
			case TENTACLE_PLAYER:
				penetrationName = "tentacle";
				break;
			case TONGUE_PARTNER:
				penetrationName = "[npc.tongue+]";
				break;
			case TONGUE_PLAYER:
				penetrationName = "[pc.tongue+]";
				break;
		}
		
		if(penetrationType.isPlayer()) {
			if(orifice.isPlayer()) {
				return "You slide your "+penetrationName+" out of your "+orificeName+".";
			} else {
				return "You slide your "+penetrationName+" out of [npc.name]'s "+orificeName+".";
			}
			
		} else {
			if(orifice.isPlayer()) {
				return "[npc.Name] slides [npc.her] "+penetrationName+" out of your "+orificeName+".";
			} else {
				return "[npc.Name] slides [npc.her] "+penetrationName+" out of [npc.her] "+orificeName+".";
				
			}
		}
	}
	
	
	protected String formatVirginityLoss(String rawInput) {
		return UtilText.formatVirginityLoss(rawInput);
	}
	protected String losingPureVirginity(){
		return UtilText.parse(Sex.getPartner(),
				"<p style='text-align:center;'>"
					+ "<b style='color:"+Colour.GENERIC_TERRIBLE.toWebHexString()+";'>Broken Virgin</b>"
				+ "</p>"
				+ "<p>"
					+ "You can't believe what's happening."
					+ " As [npc.name]'s "+(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER).getName())
					+" takes your virginity in a single thrust, you find yourself letting out a desperate gasp."
				+ "</p>"
				+ "<p style='text-align:center;'>"
					+ "[pc.thought(This is how I lose my virginity?!</br>"
							+ "To... <i>[npc.a_race]</i>?!</br>"
							+ "This can't be happening!)]"
				+ "</p>"
				+ "<p>"
					+ "You don't quite know how to react."
					+ " The virginity that you prized so highly has been suddenly taken from you, and a vacant gaze settles over your face as your [pc.pussy+] spreads lewdly around the intruding object."
				+ "</p>"
				+ "<p>"
					+ " While you were a virgin, you felt invincible."
					+ " As though you could overcome any obstacle that was placed in your way."
					+ " Now, however..."
				+ "</p>"
				+ "<p style='text-align:center;'>"
				+ "[pc.thought(Now I'm just some regular old slut...</br>"
						+ "Getting fucked by any random person I meet...</br>"
						+ "All I'm good for now is being the next lucky guy's fuck-toy...)]"
				+ "</p>"
				+ "<p>"
				+ "You're vaguely aware of [npc.name] grunting away somewhere in the background, completely oblivious to how hard you've been hit by the loss of your virginity."
				+ " With a shuddering sigh, you decide to resign yourself to the fact that now you're nothing more than a <b style='color:"+StatusEffect.FETISH_BROKEN_VIRGIN.getColour().toWebHexString()+";'>broken virgin</b>..."
				+ "</p>");
	}
	
	// Virginity loss:
	
	public String getPlayerAnalVirginityLossDescription(){
		StringBuilderSB = new StringBuilder();
		
		boolean isPenis = Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER)==PenetrationType.PENIS_PARTNER;
		boolean isTail = Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER)==PenetrationType.TAIL_PARTNER;
		
		/*
		 * Initial penetration -> Take into account wet/dry
		 * Reaction -> player masochist
		 * Reaction -> partner sadist, partner deflowering fetish
		 * End -> continues fucking you through the receding pain
		 */
		
		// Initial penetration:
		if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER).isEmpty()) {
			// Dry:
			StringBuilderSB.append(
					"<p>"
						+ "You let out a painful cry as you feel [npc.name]'s "+(isPenis?"[npc.penis+]":"")+(isTail?"[npc.tail+]":"")+" push into your dry [pc.asshole]."
						+ " Squirming and shuffling in discomfort, your cries grow louder and louder as [npc.name] starts fucking your [pc.ass]; the lack of lubrication turning your first anal experience into one of mind-numbing agony."
					+ "</p>");
			
		} else {
			 // Wet:
			StringBuilderSB.append(
					"<p>"
						+ "You let out a painful cry as you feel [npc.name]'s "+(isPenis?"[npc.penis+]":"")+(isTail?"[npc.tail+]":"")+" push into your [pc.asshole+]."
						+ " Squirming and shuffling in discomfort, you continue letting out little whimpers as [npc.name] starts fucking your [pc.ass]."
						+ " Thankfully, your [pc.asshole] was lubricated beforehand, and you dread to think of how painful your first anal experience would have been otherwise."
					+ "</p>");
		}
		
		// Player masochist reaction:
		if(Main.game.getPlayer().hasFetish(Fetish.FETISH_MASOCHIST)) {
			StringBuilderSB.append(
					"<p>"
						+ "Due to being an extreme masochist, you find your painful cries being interspersed with lewd moans of pleasure."
						+ " The pain and discomfort at the feeling of losing your anal virginity is pure bliss, and you soon find yourself [pc.moaning] in a delightful haze of overwhelming ecstasy."
					+ "</p>");
		}
		
		// Partner sadistic reaction:
		if(Sex.getPartner().hasFetish(Fetish.FETISH_SADIST)) {
			StringBuilderSB.append(
					"<p>"
						+ "With tears welling up in your [pc.eyes], you let out another painful wail as [npc.name] draws"+(isTail?" [npc.her] [npc.tail]":"")+" back, before violently thrusting deep inside you once again."
						+ " [npc.She] lets out an evil laugh as [npc.she] causes you to writhe about in pain, [npc.her] sadistic nature fuelling [npc.her] rough thrusts into your [pc.asshole] as [npc.she] ruthlessly fucks your [pc.ass]."
					+ "</p>");
		} else {
			StringBuilderSB.append(
					"<p>"
						+ "With tears welling up in your [pc.eyes], you let out another painful wail as [npc.name] draws"+(isTail?" [npc.her] [npc.tail]":"")+" back, before thrusting deep inside you once again."
						+ " This time, the pain isn't as extreme as before, and you realise that you're starting to get used to the feeling of being fucked in the ass."
					+ "</p>");
		}
		
		// Partner deflowering reaction:
		if(Sex.getPartner().hasFetish(Fetish.FETISH_DEFLOWERING)) {
			StringBuilderSB.append(
					"<p>"
						+ "[npc.speech(Oh, yes!)] [npc.she] cries, [npc.speech(Good [pc.girl], saving your anal virginity for me!"
							+ " Remember this moment, remember that <i>my</i> "+(isPenis?"cock":"")+(isTail?"tail":"")+" was the the one that turned you into "+(Main.game.getPlayer().isFeminine()?"a horny buttslut":"a little fucktoy")+"!)]"
					+ "</p>");
		}
		
		// Ending:
		StringBuilderSB.append(
				"<p>"
					+ "The throbbing, painful ache in your [pc.ass] slowly starts to fade away, and as [npc.name]'s "+(isPenis?"[npc.penis+]":"")+(isTail?"[npc.tail+]":"")
						+" pushes into your [pc.asshole+] once again, you let out a little whimper of relief as you feel that there's no accompanying stab of pain."
				+ "</p>");
		
		StringBuilderSB.append(formatVirginityLoss("You'll always remember this moment as the time that you lost your anal virginity!"));
		
		return StringBuilderSB.toString();
	}
	
	private static StringBuilder StringBuilderSB;
	public String getPlayerVaginaVirginityLossDescription(boolean isPlayerDom){
		StringBuilderSB = new StringBuilder();
		
		boolean isPenis = Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER)==PenetrationType.PENIS_PARTNER;
		boolean isTail = Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER)==PenetrationType.TAIL_PARTNER;
		
		/*
		 * Initial penetration -> Take into account wet/dry
		 * Reaction -> player masochist
		 * Reaction -> partner sadist, partner deflowering fetish
		 * End -> continues fucking you through the receding pain
		 */
		
		// Initial penetration:
		if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).isEmpty()) {
			// Dry:
			StringBuilderSB.append(
					"<p>"
						+ "As [npc.name]'s "+(isPenis?"[npc.penis+]":"")+(isTail?"[npc.tail+]":"")+" drives deep into your dry [pc.pussy], your vision suddenly explodes in stars, and a painful, high-pitched shriek escapes from between your lips."
						+ " Being penetrated without any form of lubrication would be uncomfortable at the best of times, but due to the fact that you're still a virgin, it's somewhat more than just a little discomfort,"
							+ " and your shriek turns into a shuddering cry as you shuffle about in pure agony."
					+ "</p>");
			
		} else {
			 // Wet:
			StringBuilderSB.append(
					"<p>"
						+ "As [npc.name]'s "+(isPenis?"[npc.penis+]":"")+(isTail?"[npc.tail+]":"")+" drives deep into your [pc.pussy+], your vision suddenly narrows down, and a painful, desperate wail escapes from between your lips."
						+ " Luckily, your pussy was lubricated before being penetrated, but due to the fact that you're still a virgin, it isn't enough to completely prevent the pain you now feel between your legs,"
							+ " and your wail turns into a shuddering moan as you shuffle about in discomfort."
					+ "</p>");
		}
		
		// Player masochist reaction:
		if(Main.game.getPlayer().hasFetish(Fetish.FETISH_MASOCHIST)) {
			StringBuilderSB.append(
					"<p>"
						+ "Due to being an extreme masochist, you find your painful cries being interspersed with lewd moans of pleasure."
						+ " The agony between your legs is pure bliss, and you focus on the pain as you squeal and moan in a delightful haze of overwhelming ecstasy."
					+ "</p>");
		}
		
		// Partner sadistic reaction:
		if(Sex.getPartner().hasFetish(Fetish.FETISH_SADIST)) {
			StringBuilderSB.append(
					"<p>"
						+ "Trying desperately to clench your legs together, you let out another painful wail as [npc.name] draws"+(isTail?" [npc.her] [npc.tail]":"")+" back, before violently thrusting deep inside you once again."
						+ " [npc.She] lets out an evil laugh as [npc.she] causes you to writhe about in pain, [npc.her] sadistic nature fuelling [npc.her] rough thrusts into your pussy as [npc.she] ruthlessly tears through your hymen."
					+ "</p>");
		} else {
			StringBuilderSB.append(
					"<p>"
						+ "Trying desperately to clench your legs together, you let out another painful wail as [npc.name] draws"+(isTail?" [npc.her] [npc.tail]":"")+" back, before thrusting deep inside you once again."
						+ " This time, the pain isn't as extreme as before, and you realise that the initial hurt was due to your hymen being torn."
					+ "</p>");
		}
		
		// Partner deflowering reaction:
		if(Sex.getPartner().hasFetish(Fetish.FETISH_DEFLOWERING)) {
			StringBuilderSB.append(
					"<p>"
						+ "[npc.speech(Oh, yes!)] [npc.she] cries, [npc.speech(Good [pc.girl], saving your virginity for me!"
							+ " Remember this moment, remember that <i>my</i> "+(isPenis?"cock":"")+(isTail?"tail":"")+" was the the one that broke you in!)]"
					+ "</p>");
		}
		
		// Ending:
		if (Main.game.getPlayer().hasFetish(Fetish.FETISH_PURE_VIRGIN)) {
			StringBuilderSB.append(
					"<p>"
						+ "As the pain recedes into a dull, throbbing ache between your legs, you feel a little trickle of blood running out of your now-broken-in pussy, and you can't help but let out yet another whimpering cry."
						+ " The throbbing, painful ache in your groin slowly starts to fade away, and as [npc.name]'s "+(isPenis?"[npc.penis+]":"")+(isTail?"[npc.tail+]":"")
							+" pushes into your [pc.pussy+] once again, you let out a sigh of relief as you feel that there's no accompanying stab of pain."
					+ "</p>");
		} else {
			StringBuilderSB.append(
					"<p>"
						+ "The throbbing, painful ache in your groin slowly starts to fade away, and as [npc.name]'s "+(isPenis?"[npc.penis+]":"")+(isTail?"[npc.tail+]":"")
							+" pushes into your [pc.pussy+] once again, you let out a sigh of relief as you feel that there's no accompanying stab of pain."
					+ "</p>");
		}
		
		StringBuilderSB.append(formatVirginityLoss("Your hymen has been torn; you have lost your virginity!"));
		
		if(Main.game.getPlayer().hasFetish(Fetish.FETISH_PURE_VIRGIN)) {
			StringBuilderSB.append(losingPureVirginity());
		}
		
		return StringBuilderSB.toString();
	}
	
	// TODO The difference in writing styles feels too jarring at the moment...
	// This isn't a criticism of your writing style at all (which is very good), it's just that I feel like it doesn't fit in with all the surrounding descriptions.
	
//	public String getPlayerVaginaVirginityLossDescription(boolean isPlayerDom){
//		VelocityContext context = new VelocityContext();
//        context.put("player", Main.game.getPlayer());
//        context.put("game", Main.game);
//        context.put("partner", Sex.getPartner());
//        context.put("dominant", isPlayerDom);
//        context.put("penetratedBy", Sex.playerPenetratedBy("VAGINA"));
//        context.put("playerVaginaWet", Sex.isPlayerWet("VAGINA"));
//        context.put("txt", UtilText.class);
//        return UtilText.parse("/res/txt/dialogue/sex/Generic/PlayerVaginaVirginityLossDescription.txt", context);
//	}
	
	public String getPlayerNippleVirginityLossDescription(){
		return formatVirginityLoss("You'll always remember this moment as the time that you lost your nipple virginity!");
	}
	
	public String getPlayerUrethraVirginityLossDescription(){
		return formatVirginityLoss("You have lost your urethral virginity!");
	}
	
	public String getPlayerMouthVirginityLossDescription(){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER)==PenetrationType.PENIS_PARTNER 
				|| Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER)==PenetrationType.PENIS_PLAYER) {
			return formatVirginityLoss("You'll always remember this moment as the first time that you sucked a cock!");
			
		} else if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER)==PenetrationType.TAIL_PARTNER) {
			return formatVirginityLoss("You'll always remember this moment as the first time that you sucked someone's tail!");
			
		} else {
			return formatVirginityLoss("You'll always remember this moment as the first time that you took something down your throat!");
		}
	}

	
	public String getPartnerAnalVirginityLossDescription(){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER).isPlayer()) {
			return formatVirginityLoss("You have taken [npc.name]'s anal virginity!")
					+(Main.game.getPlayer().hasFetish(Fetish.FETISH_DEFLOWERING)
							?"<p style='text-align:center;><i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Due to your deflowering fetish, you gain</i>"
							+ " <i style='color:"+Colour.GENERIC_EXPERIENCE.toWebHexString()+";'>"+Fetish.getExperienceGainFromTakingOtherVirginity(Main.game.getPlayer())+"</i>"
							+ " <i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>experience!</i></p>"
							:"");
			
		} else {
			return formatVirginityLoss("[npc.Name] has taken [npc.her] own anal virginity!");
		}
	}
	
	public String getPartnerVaginaVirginityLossDescription(){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER).isPlayer()) {
			return formatVirginityLoss("[npc.Name]'s hymen has been torn; you have taken [npc.her] virginity!")
					+(Main.game.getPlayer().hasFetish(Fetish.FETISH_DEFLOWERING)
							?"<p style='text-align:center;><i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Due to your deflowering fetish, you gain</i>"
							+ " <i style='color:"+Colour.GENERIC_EXPERIENCE.toWebHexString()+";'>"+Fetish.getExperienceGainFromTakingVaginalVirginity(Main.game.getPlayer())+"</i>"
							+ " <i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>experience from taking [npc.name]'s virginity!</i></p>"
							:"");
			
		} else {
			return formatVirginityLoss("[npc.Name] has taken [npc.her] own virginity!");
		}
	}
	
	public String getPartnerNippleVirginityLossDescription(){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER).isPlayer()) {
			return formatVirginityLoss("You have taken [npc.name]'s nipple virginity!")
					+(Main.game.getPlayer().hasFetish(Fetish.FETISH_DEFLOWERING)
							?"<p style='text-align:center;><i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Due to your deflowering fetish, you gain</i>"
							+ " <i style='color:"+Colour.GENERIC_EXPERIENCE.toWebHexString()+";'>"+Fetish.getExperienceGainFromTakingOtherVirginity(Main.game.getPlayer())+"</i>"
							+ " <i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>experience!</i></p>"
							:"");
			
		} else {
			return formatVirginityLoss("[npc.Name] has taken [npc.her] own nipple virginity!");
		}
	}
	
	public String getPartnerUrethraVirginityLossDescription(){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.URETHRA_PARTNER).isPlayer()) {
			return formatVirginityLoss("You have taken [npc.name]'s urethral virginity!")
					+(Main.game.getPlayer().hasFetish(Fetish.FETISH_DEFLOWERING)
							?"<p style='text-align:center;><i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Due to your deflowering fetish, you gain</i>"
							+ " <i style='color:"+Colour.GENERIC_EXPERIENCE.toWebHexString()+";'>"+Fetish.getExperienceGainFromTakingOtherVirginity(Main.game.getPlayer())+"</i>"
							+ " <i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>experience!</i></p>"
							:"");
		} else {
			return formatVirginityLoss("[npc.Name] has taken [npc.her] own urethral virginity!");
		}
	}
	
	public String getPartnerMouthVirginityLossDescription(){
		if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER).isPlayer()) {
			return formatVirginityLoss("You have given [npc.name] [npc.her] first oral experience!")
					+(Main.game.getPlayer().hasFetish(Fetish.FETISH_DEFLOWERING)
							?"<p style='text-align:center;><i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Due to your deflowering fetish, you gain</i>"
							+ " <i style='color:"+Colour.GENERIC_EXPERIENCE.toWebHexString()+";'>"+Fetish.getExperienceGainFromTakingOtherVirginity(Main.game.getPlayer())+"</i>"
							+ " <i style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>experience!</i></p>"
							:"");
			
		} else {
			return formatVirginityLoss("[npc.Name] has given [npc.herself] [npc.her] first oral experience!");
		}
	}
	
	
	// Stretching:
	
	protected String formatStretching(String rawInput) {
		return UtilText.formatStretching(rawInput);
	}

	
	public String getPlayerAssStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.asshole+] is being stretched."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
								"Your [pc.asshole+] is being stretched."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
								"Your [pc.asshole+] is being stretched."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
								"Your [pc.asshole+] is being stretched."));
			default:
				return "Your [pc.asshole+] is being stretched.";
		}
	}

	
	public String getPlayerBreastsStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.nipples+] are being stretched."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.nipples+] are being stretched."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.nipples+] are being stretched."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.nipples+] are being stretched."));
			default:
				return "Your [pc.nipples+] are being stretched.";
		}
	}

	
	public String getPlayerPenisStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your urethra is being stretched."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your urethra is being stretched."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your urethra is being stretched."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your urethra is being stretched."));
			default:
				return "Your urethra is being stretched.";
		}
	}

	
	public String getPlayerVaginaStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.pussy+] is being stretched."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.pussy+] is being stretched."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.pussy+] is being stretched."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.pussy+] is being stretched."));
			default:
				return "Your [pc.pussy+] is being stretched.";
		}
	}

	
	public String getPlayerMouthStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"You're struggling to fit [npc.name]'s fingers down your throat."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"You're struggling to fit [npc.name]'s [npc.penis+] down your throat."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"You're struggling to fit [npc.name]'s tail down your throat."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"You're struggling to fit [npc.name]'s tongue down your throat.")); // I guess for when demonic tongues are put into the game
			default:
				return "Your throat is being stretched out.";
		}
	}

	
	public String getPartnerAssStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your fingers are stretching out [npc.name]'s [npc.asshole+]."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.penis+] is stretching out [npc.name]'s [npc.asshole+]."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tail is stretching out [npc.name]'s [npc.asshole+]."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tongue is stretching out [npc.name]'s [npc.asshole+]."));
			default:
				return "[npc.Name]'s [npc.asshole+] is being stretched.";
		}
	}

	
	public String getPartnerBreastsStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your fingers are stretching out [npc.name]'s "+Sex.getPartner().getNippleName(true)+"."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.penis+] is stretching out [npc.name]'s "+Sex.getPartner().getNippleName(true)+"."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tail is stretching out [npc.name]'s "+Sex.getPartner().getNippleName(true)+"."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tongue is stretching out [npc.name]'s "+Sex.getPartner().getNippleName(true)+"."));
			default:
				return "[npc.Name]'s "+Sex.getPartner().getNippleName(true)+" are being stretched.";
		}
	}

	
	public String getPartnerPenisStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your fingers are stretching out [npc.name]'s urethra."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.penis+] is stretching out [npc.name]'s urethra."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tail is stretching out [npc.name]'s urethra."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tongue is stretching out [npc.name]'s urethra."));
			default:
				return "[npc.Name]'s urethra is being stretched.";
		}
	}

	
	public String getPartnerVaginaStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your fingers are stretching out [npc.name]'s [npc.pussy+]."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your [pc.penis+] is stretching out [npc.name]'s [npc.pussy+]."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tail is stretching out [npc.name]'s [npc.pussy+]."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"Your tongue is stretching out [npc.name]'s [npc.pussy+]."));
			default:
				return "[npc.Name]'s [npc.pussy+] is being stretched.";
		}
	}

	
	public String getPartnerMouthStretchingDescription(PenetrationType penetrationType) {
		switch(penetrationType) {
			case FINGER_PLAYER: case FINGER_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"[npc.Name] is struggling to fit your fingers down [npc.her] throat."));
			case PENIS_PLAYER: case PENIS_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"[npc.Name] is struggling to fit your [pc.penis+] down [npc.her] throat."));
			case TAIL_PLAYER: case TAIL_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"[npc.Name] is struggling to fit your tail down [npc.her] throat."));
			case TONGUE_PLAYER: case TONGUE_PARTNER:
				return formatStretching(UtilText.returnStringAtRandom(
							"[npc.Name] is struggling to fit your tongue down [npc.her] throat."));
			default:
				return "[npc.Name]'s throat is being stretched out.";
		}
	}

	// Finished stretching:
	
	
	public String getPlayerAssStretchingFinishedDescription() {
		return formatStretching("Your asshole has been stretched out to a comfortable size.");
	}

	
	public String getPlayerBreastsStretchingFinishedDescription() {
		return formatStretching("Your nipples have been stretched out to a comfortable size.");
	}

	
	public String getPlayerPenisStretchingFinishedDescription() {
		return formatStretching("Your urethra has been stretched out to a comfortable size.");
	}

	
	public String getPlayerVaginaStretchingFinishedDescription() {
		return formatStretching("Your pussy has been stretched out to a comfortable size.");
	}

	
	public String getPlayerMouthStretchingFinishedDescription() {
		return formatStretching("Your throat has been stretched out to a comfortable size.");
	}

	
	public String getPartnerAssStretchingFinishedDescription() {
		return formatStretching("[npc.Name] lets out [npc.a_moan+] as [npc.her] [npc.asshole+] finishes stretching out to a comfortable size.");
	}

	
	public String getPartnerBreastsStretchingFinishedDescription() {
		return formatStretching("[npc.Name] lets out [npc.a_moan+] as [npc.her] [npc.nipples+] finish stretching out to a comfortable size.");
	}

	
	public String getPartnerPenisStretchingFinishedDescription() {
		return formatStretching("[npc.Name] lets out [npc.a_moan+] as [npc.her] urethra finishes stretching out to a comfortable size.");
	}

	
	public String getPartnerVaginaStretchingFinishedDescription() {
		return formatStretching("[npc.Name] lets out [npc.a_moan+] as [npc.her] [npc.pussy+] finishes stretching out to a comfortable size.");
	}

	
	public String getPartnerMouthStretchingFinishedDescription() {
		return formatStretching("[npc.Name] lets out a muffled [npc.moan] as [npc.her] throat finishes stretching out to a comfortable size.");
	}

	
	// Too loose:
	
	protected String formatTooLoose(String rawInput) {
		return UtilText.formatTooLoose(rawInput);
	}
	
	
	public String getPlayerAssTooLooseDescription() {
		return formatTooLoose("Your asshole is too loose to provide much pleasure...");
	}

	
	public String getPlayerBreastsTooLooseDescription() {
		return formatTooLoose("Your nipples are too loose to provide much pleasure...");
	}

	
	public String getPlayerPenisTooLooseDescription() {
		return formatTooLoose("Your urethra is too loose to provide much pleasure...");
	}

	
	public String getPlayerVaginaTooLooseDescription() {
		return formatTooLoose("Your pussy is too loose to provide much pleasure...");
	}

	
	public String getPlayerMouthTooLooseDescription() {
		return formatTooLoose("");
	}

	
	public String getPartnerAssTooLooseDescription() {
		return formatTooLoose("[npc.Her] asshole is too loose to provide much pleasure...");
	}

	
	public String getPartnerBreastsTooLooseDescription() {
		return formatTooLoose("[npc.Her] nipples are too loose to provide much pleasure...");
	}

	
	public String getPartnerPenisTooLooseDescription() {
		return formatTooLoose("[npc.Her] urethra is too loose to provide much pleasure...");
	}

	
	public String getPartnerVaginaTooLooseDescription() {
		return formatTooLoose("[npc.Her] pussy is too loose to provide much pleasure...");
	}

	
	public String getPartnerMouthTooLooseDescription() {
		return formatTooLoose("");
	}
	
}
