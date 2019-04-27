# DeepCloner
Deep copy of an object that have exact copy of all the fields of original object by extends DeepCloner class

# Usage
- extends your class from DeepCloner
```
class YourClass extends DeepCloner { }
```
- call clone method by pass an object that instance from your class
```
YourClass yourClassCopy = new YourClass();
yourClass.clone(yourClassCopy);
```
