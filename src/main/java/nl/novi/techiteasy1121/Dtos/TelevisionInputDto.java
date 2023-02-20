package nl.novi.techiteasy1121.Dtos;

// Let er op dat je hier uit het "jakarta" package importeert
import jakarta.validation.constraints.*;

// Deze klasse wordt gebruikt voor je Post en Put methodes, dus daar waar je een Television als body mee geeft in Postman.

public class TelevisionInputDto {

        @NotNull(message = "Type is required") // Type moet ingevuld verplicht worden in je JSON, je krijgt een message als je dit niet doet.
        private String type;
        @NotNull(message = "Brand is required")
        private String brand;
        @Size(max = 20, message = "Name must be between 0-20 characters") // maximale lengte van de string, min is automatisch 0.
        private String name;
        @Positive(message = "Price must be higher than zero")
        private Double price;
        private Double availableSize;
        private Double refreshRate;
        private String screenType;
        private String screenQuality;
        private Boolean smartTv;
        private Boolean wifi;
        private Boolean voiceControl;
        @AssertTrue(message = "All television must be hdr minimum")
        private Boolean hdr;
        private Boolean bluetooth;
        private Boolean ambiLight;
        @PositiveOrZero(message = "Television cannot have negative stock")
        private Integer originalStock;
        private Integer sold;

        // We hebben geen constrctor nodig. We zullen nooit zelf een TelevisionInputDto maken met die constructor,
        // alleen Spring/Jackson doet dat en die doet dat aan de hand van de setters, niet de constructor.

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

