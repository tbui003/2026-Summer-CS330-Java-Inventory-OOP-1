package edu.odu.cs.cs330.items;

import java.util.Scanner;

@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.BeanMembersShouldSerialize"
})
public class Consumable extends Item {
    protected String effect;
    protected int uses;

    public Consumable()
    {
        super("[Placeholder]", true);
        this.effect = "";
        this.uses = 0;
    }

    public Consumable(Consumable src)
    {
        super(src.getName(), src.isStackable());

        this.effect = src.getEffect();
        this.uses = src.getNumberOfUses();
    }

    public String getEffect() { return this.effect; }
    public void setEffect(String newEff) { this.effect = newEff; }
    public int getNumberOfUses() { return this.uses; }
    public void setNumberOfUses(int allowed) { this.uses = allowed; }

    @Override
    public void read(Scanner snr)
    {
        super.name = snr.next();
        this.effect = snr.next();
        this.uses = snr.nextInt();
    }

    @Override
    public Item clone()
    {
        return new Consumable(this);
    }

    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Consumable)) {
            return false;
        }

        Consumable rhsItem = (Consumable) rhs;

        return this.name.equals(rhsItem.name)
            && this.effect.equals(rhsItem.effect);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode()
            + this.effect.hashCode();
    }

    @Override
    public String toString()
    {
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Eft: %s", this.getEffect()),
            String.format("  Use: %d", this.getNumberOfUses()),
            ""
        );
    }
}
