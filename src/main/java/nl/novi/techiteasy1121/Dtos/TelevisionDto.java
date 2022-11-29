package nl.novi.techiteasy1121.Dtos;

// Deze klasse wordt gebruikt in je Get, Post en Put methodes. Overal waat je een Television als returnwaarde wilt geven.
// Een input DTO behoet geen validatie

public class TelevisionDto {
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;

    // We gebruiken nu geen all-args-constructor, java maakt automatisch al een no-args-constructor. Dus we hoeven geen constructor te maken.
    // Als we wel een all-args-constructor willen gebruiken (bijvoorbeeld in de service.translatetoDto() methode), dan
    // zullen we ook een no-args methode moeten maken, omdat java deze dan niet meer automatisch maakt.

//    public TelevisionDto() {
//    }
//
//    public TelevisionDto(Long id, String type, String brand, String name, Double price, Double availableSize, Double refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock, Integer sold) {
//        this.id = id;
//        this.type = type;
//        this.brand = brand;
//        this.name = name;
//        this.price = price;
//        this.availableSize = availableSize;
//        this.refreshRate = refreshRate;
//        this.screenType = screenType;
//        this.screenQuality = screenQuality;
//        this.smartTv = smartTv;
//        this.wifi = wifi;
//        this.voiceControl = voiceControl;
//        this.hdr = hdr;
//        this.bluetooth = bluetooth;
//        this.ambiLight = ambiLight;
//        this.originalStock = originalStock;
//        this.sold = sold;
//    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public Double getRefreshRate() {
        return refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public void setRefreshRate(Double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}
