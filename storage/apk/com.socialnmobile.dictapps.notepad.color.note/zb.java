import android.util.MonthDisplayHelper;

// 
// Decompiled by Procyon v0.5.29
// 

public final class zb extends MonthDisplayHelper
{
    private int a;
    private int b;
    
    public zb(final int n, final int n2, final int n3, final int n4) {
        super(n, n2, n4);
        this.a = this.getRowOf(n3);
        this.b = this.getColumnOf(n3);
    }
    
    public final int a() {
        return this.getDayAt(this.a, this.b);
    }
    
    public final void a(final int a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public final int b() {
        if (this.isWithinCurrentMonth(this.a, this.b)) {
            return 0;
        }
        if (this.a == 0) {
            return -1;
        }
        return 1;
    }
    
    public final boolean b(final int n, final int n2) {
        return this.a == n && this.b == n2;
    }
    
    public final boolean c() {
        if (this.isWithinCurrentMonth(-1 + this.a, this.b)) {
            --this.a;
            return false;
        }
        this.previousMonth();
        this.a = 5;
        while (!this.isWithinCurrentMonth(this.a, this.b)) {
            --this.a;
        }
        return true;
    }
    
    public final boolean d() {
        if (this.isWithinCurrentMonth(1 + this.a, this.b)) {
            ++this.a;
            return false;
        }
        this.nextMonth();
        this.a = 0;
        while (!this.isWithinCurrentMonth(this.a, this.b)) {
            ++this.a;
        }
        return true;
    }
    
    public final boolean e() {
        if (this.b == 0) {
            --this.a;
            this.b = 6;
        }
        else {
            --this.b;
        }
        if (this.isWithinCurrentMonth(this.a, this.b)) {
            return false;
        }
        this.previousMonth();
        final int numberOfDaysInMonth = this.getNumberOfDaysInMonth();
        this.a = this.getRowOf(numberOfDaysInMonth);
        this.b = this.getColumnOf(numberOfDaysInMonth);
        return true;
    }
    
    public final boolean f() {
        if (this.b == 6) {
            ++this.a;
            this.b = 0;
        }
        else {
            ++this.b;
        }
        if (this.isWithinCurrentMonth(this.a, this.b)) {
            return false;
        }
        this.nextMonth();
        this.a = 0;
        this.b = 0;
        while (!this.isWithinCurrentMonth(this.a, this.b)) {
            ++this.b;
        }
        return true;
    }
}
