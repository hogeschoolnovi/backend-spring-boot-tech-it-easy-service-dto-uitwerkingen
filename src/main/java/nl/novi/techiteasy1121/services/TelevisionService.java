package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.Dtos.TelevisionDto;
import nl.novi.techiteasy1121.Dtos.TelevisionInputDto;
import nl.novi.techiteasy1121.Dtos.TelevisionSalesDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Zet de annotatie boven de klasse, zodat Spring het herkent en inleest als Service.
@Service
public class TelevisionService {

    // We importeren de repository nu in de service in plaats van in de controller.
    // dit mag met constructor injection of autowire.
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository){
        this.televisionRepository = televisionRepository;
    }

    // Vanuit de repository kunnen we een lijst van Televisions krijgen, maar de communicatie container tussen Service en
    // Controller is de Dto. We moeten de Televisions dus vertalen naar TelevisionDtos. Dit moet een voor een, omdat
    // de translateToDto() methode geen lijst accepteert als argument, dus gebruiken we een for-loop.
    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvList = televisionRepository.findAll();
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
            TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    // Vanuit de repository kunnen we een lijst van Televisions met een bepaalde brand krijgen, maar de communicatie
    // container tussen Service en Controller is de Dto. We moeten de Televisions dus vertalen naar TelevisionDtos. Dit
    // moet een voor een, omdat de translateToDto() methode geen lijst accepteert als argument, dus gebruiken we een for-loop.
    public List<TelevisionDto> getAllTelevisionsByBrand(String brand) {
        List<Television> tvList = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
            TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    // Deze methode is inhoudelijk hetzelfde als het was in de vorige opdracht. Wat verandert is, is dat we nu checken
    // op optional.isPresent in plaats van optional.isEmpty en we returnen een TelevisionDto in plaats van een Television.
    public TelevisionDto getTelevisionById(Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (televisionOptional.isPresent()){
            Television tv = televisionOptional.get();
            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }

    // In deze methode moeten we twee keer een vertaal methode toepassen.
    // De eerste keer van dto naar televsion, omdat de parameter een dto is.
    // De tweede keer van television naar dto, omdat de return waarde een dto is.
    public TelevisionDto addTelevision(TelevisionInputDto dto) {

        Television tv = transferToTelevision(dto);
        televisionRepository.save(tv);

        return transferToDto(tv);
    }

    // Deze methode is inhoudelijk neit veranderd. Het is alleen verplaatst naar de Service laag.
    public void deleteTelevision(@RequestBody Long id) {

        televisionRepository.deleteById(id);

    }

    // Deze methode is inhoudelijk niet veranderd, alleen staat het nu in de Service laag en worden er Dto's en
    // vertaal methodes gebruikt.
    public TelevisionDto updateTelevision(Long id, TelevisionInputDto newTelevision) {

        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (televisionOptional.isPresent()){

            Television television1 = televisionOptional.get();


            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setAvailableSize(newTelevision.getAvailableSize());
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setBluetooth(newTelevision.getBluetooth());
            television1.setBrand(newTelevision.getBrand());
            television1.setHdr(newTelevision.getHdr());
            television1.setName(newTelevision.getName());
            television1.setOriginalStock(newTelevision.getOriginalStock());
            television1.setPrice(newTelevision.getPrice());
            television1.setRefreshRate(newTelevision.getRefreshRate());
            television1.setScreenQuality(newTelevision.getScreenQuality());
            television1.setScreenType(newTelevision.getScreenType());
            television1.setSmartTv(newTelevision.getSmartTv());
            television1.setSold(newTelevision.getSold());
            television1.setType(newTelevision.getType());
            television1.setVoiceControl(newTelevision.getVoiceControl());
            television1.setWifi(newTelevision.getWifi());
            Television returnTelevision = televisionRepository.save(television1);

            return transferToDto(returnTelevision);

        } else {

            throw new  RecordNotFoundException("geen televisie gevonden");

        }

    }

    // Bonus opdracht:
    public List<TelevisionSalesDto> getAllTelevisionSalesInfo(){
        //haal alle televisions uit de database
        List<Television> televisions = televisionRepository.findAll();
        //maak een lege dto lijst die we kunnen gaan vullen
        List<TelevisionSalesDto> sales = new ArrayList<>();

        // loop door de television lijst heen om uit elke television de sales info te extraheren en dat in een salesdto te zetten.
        for(Television t : televisions){
            // maak een nieuw dto object
            TelevisionSalesDto dto = new TelevisionSalesDto();
            // vul de dto
            dto.setId(t.getId());
            dto.setPrice(t.getPrice());
            dto.setSold(t.getSold());
            dto.setOriginalStock(t.getOriginalStock());
            //voeg de lijst
            sales.add(dto);
        }
        //return de dto lijst
        return sales;
    }

    // Dit is de vertaal methode van TelevisionInputDto naar Television.
    public Television transferToTelevision(TelevisionInputDto dto){
        var television = new Television();

        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }

    // Dit is de vertaal methode van Television naar TelevisionDto
    public TelevisionDto transferToDto(Television television){
        TelevisionDto dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getWifi());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }
}
