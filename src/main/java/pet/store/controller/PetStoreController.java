package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

    @Autowired
    private PetStoreService petStoreService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PetStoreData insertPetStore(@RequestBody PetStoreData petStoreData) {
        log.info("Creating pet store {}", petStoreData);
        return petStoreService.savePetStore(petStoreData);
    }

    @PutMapping("/{petStoreId}")
    public PetStoreData updatePetStore(@PathVariable Long petStoreId,
                                       @RequestBody PetStoreData petStoreData) {
        petStoreData.setPetStoreId(petStoreId);
        log.info("Updating pet store {}", petStoreData);
        return petStoreService.savePetStore(petStoreData);
    }
}
