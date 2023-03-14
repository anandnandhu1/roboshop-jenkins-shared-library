def new1() {
    print "hello"
    def xyz="hello"
    print "abc = ${abc}"
    print "xyz = ${xyz}"

    if (abc == "somedata") {
        print "yes"
    } else {
        print "no"
    }

    def x=2
    def y=0
    while(x > y) {
        println"${x}"
        y++
    }

    for(int i = 0;i<5;i++) {
        println(i);
    }
    def array = [0,1,2,3];
    for(i in array) {
        println(i);
    }
}