package map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import interfaces.Surface;
import interfaces.Item;
import exceptions.ItemNotFoundException;

/**
 * The item plane is used to retrieve and store items associated with locations
 * on the map with which it is associated with
 * @author meguca
 *
 */
public class ItemPlane implements Serializable{
	
	/**
	 * Creates a new item plane for a map
	 * @param aMap			The game map with which the item plane is associated with
	 */
	public ItemPlane(GameMap aMap){
		itemMap = new HashMap<Surface, ArrayList<Item>>();
	}
	
	/**
	 * Returns an array of all the items on a particular surface
	 * @param aSurface		The surface to check
	 * @return				Items on the surface
	 */
	public ArrayList<Item> getItems(Surface aSurface){
		if(itemMap.get(aSurface) == null){
			ArrayList<Item> newItemList = new ArrayList<Item>();
			itemMap.put(aSurface, newItemList);
		}
		return itemMap.get(aSurface);
	}
	
	/**
	 * Adds an item to the array of items on a surface,
	 * if no array exists for a surface yet, one is created
	 * and the item is added to it.
	 * @param surface		The surface to add to
	 * @param item			The item to add
	 */
	public void placeItem(Surface surface, Item item){
		if(itemMap.containsKey(surface)){
			itemMap.get(surface).add(item);
		} else{
			ArrayList<Item> newItems = new ArrayList();
			newItems.add(item);
			itemMap.put(surface, newItems);
		}
	}
    
    public void removeItem(Surface surface, Item item) throws ItemNotFoundException{
        /*if(itemMap.containsKey(surface) &&
                itemMap.getValue(surface) != null &&
                itemMap.getValue(surface).size() != 0 &&
                itemMap.getValue(surface).contains(item)){
           itemMap.getValue(surface).remove(item);     
        }else{
            throw new ItemNotFoundException();
        }*/
    }
	

	private HashMap<Surface, ArrayList<Item>> itemMap;
}
