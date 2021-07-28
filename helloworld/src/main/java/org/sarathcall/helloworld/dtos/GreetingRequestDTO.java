package org.sarathcall.helloworld.dtos;

import java.util.Objects;

public class GreetingRequestDTO {
    String name;
    String locale;


    public GreetingRequestDTO() {
    }

    public GreetingRequestDTO(String name, String locale) {
        this.name = name;
        this.locale = locale;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public GreetingRequestDTO name(String name) {
        setName(name);
        return this;
    }

    public GreetingRequestDTO locale(String locale) {
        setLocale(locale);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GreetingRequestDTO)) {
            return false;
        }
        GreetingRequestDTO greetingRequestDTO = (GreetingRequestDTO) o;
        return Objects.equals(name, greetingRequestDTO.name) && Objects.equals(locale, greetingRequestDTO.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, locale);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", locale='" + getLocale() + "'" +
            "}";
    }
    
}
