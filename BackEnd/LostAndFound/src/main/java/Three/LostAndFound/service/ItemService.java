package Three.LostAndFound.service;

import Three.LostAndFound.model.Item;
import Three.LostAndFound.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService{
    @Autowired
    private ItemRepository itemRepository;

    // CREATE
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // READ (ALL)
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // READ (BY ID)
    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    // READ (BY TYPE: LOST/FOUND)
    public List<Item> getItemsByType(String type) {
        return itemRepository.findByType(type);
    }
    // UPDATE
//    public Item updateItem(Item updatedItem) {
//        return itemRepository.findById(updatedItem.getId())
//                .map(item -> {
//                    item.setTitle(updatedItem.getTitle());
//                    item.setDescription(updatedItem.getDescription());
//                    item.setLocation(updatedItem.getLocation());
//                    item.setType(updatedItem.getType());
//                    return itemRepository.save(item);
//                })
//                .orElseThrow(() -> new RuntimeException("Item not found with id: " + updatedItem.getId()));
//    }

    // DELETE
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}