package cz.soft.vojta_kudlacek.VazenyPrumerAndroid

class Grade(_grade:Byte,_weight:Byte) {
    private var grade : Byte = -1
    private var weight : Byte = -1

    init
    {
        this.grade = _grade
        this.weight = _weight
    }
    fun getGrade() : Byte
    {
        return  grade
    }

    fun getWeight() : Byte
    {
        return weight
    }

}