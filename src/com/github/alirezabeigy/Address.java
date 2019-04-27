package com.github.alirezabeigy;

class Address extends DeepCloner {
    private String name;
    private String full_address;

    private Address() {
    }

    private Address(String name, String full_address) {
        this.name = name;
        this.full_address = full_address;
    }

    String getFullAddress() {
        return full_address;
    }

    static class Builder {
        String name;
        String full_address;

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder address(String full_address) {
            this.full_address = full_address;
            return this;
        }

        Address build() {
            return new Address(name, full_address);
        }
    }
}
