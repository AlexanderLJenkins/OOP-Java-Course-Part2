/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Alex Jenkins
 */
public class MaxWeightBox extends Box {

    private final int maxWeight;
    private Collection<Thing> items;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<Thing>();
    }
    
    public int currentWeightOfBox() {
        int weight = 0;
        if (items.isEmpty()) {
            return weight;
        }
        for (Thing thing : items) {
            weight += thing.getWeight();
        }
        return weight;
    }
    
    @Override
    public void add(Thing thing) {
        // Things can be added to the box if less than box weight
        if (thing.getWeight() + currentWeightOfBox() <= maxWeight) {
            items.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return items.contains(thing);
    }
    
}
