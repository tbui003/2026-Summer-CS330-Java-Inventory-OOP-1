package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    protected int defense;

    public Armour()
    {
        super();
        this.defense = 0;
    }

    public Armour(Armour src)
    {
        super(src.getName());

        this.stackable = src.isStackable();
        this.durability = src.getDurability();
        this.material = src.getMaterial();
        this.modifier = src.getModifier();
        this.modifierLevel = src.getModifierLevel();
        this.element = src.getElement();
        this.defense = src.getDefense();
    }

    public int getDefense() { return this.defense; }
    public void setDefense(int def) { this.defense = def; }

    @Override
    public void read(Scanner snr)
    {
        super.name = snr.next();
        super.material = snr.next();
        super.durability = snr.nextInt();
        this.defense = snr.nextInt();
        super.modifier = snr.next();
        super.modifierLevel = snr.nextInt();
        super.element = snr.next();
    }

    @Override
    public Item clone()
    {
        return new Armour(this);
    }

    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        return this.name.equals(rhsItem.name)
            && this.material.equals(rhsItem.material)
            && this.modifier.equals(rhsItem.modifier)
            && this.element.equals(rhsItem.element);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode()
            + this.material.hashCode()
            + this.modifier.hashCode()
            + this.element.hashCode();
    }

    @Override
    public String toString()
    {
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Dur: %d", super.getDurability()),
            String.format("  Def: %d", this.getDefense()),
            String.format("  Mtl: %s", super.getMaterial()),
            String.format(
                "  Mdr: %s (Lvl %d)",
                super.getModifier(),
                super.getModifierLevel()
            ),
            String.format("  Emt: %s", super.getElement()),
            ""
        );
    }
}