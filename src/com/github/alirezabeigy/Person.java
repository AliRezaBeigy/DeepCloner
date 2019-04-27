package com.github.alirezabeigy;

class Person extends DeepCloner {

    private Name name;
    private Address address;

    private Person() {
    }

    private Person(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    Address getAddress() {
        return address;
    }

    Name getName() {
        return name;
    }

    void setName(Name name) {
        this.name = name;
    }

    static class Builder {
        Address address;
        Name name;

        Builder name(Name name) {
            this.name = name;
            return this;
        }

        Builder address(Address address) {
            this.address = address;
            return this;
        }

        Person build() {
            return new Person(name, address);
        }
    }
}
