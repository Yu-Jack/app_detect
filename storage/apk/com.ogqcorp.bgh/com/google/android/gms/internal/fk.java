// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

final class fk implements fg
{
    final /* synthetic */ ff a;
    
    private fk(final ff a) {
        this.a = a;
    }
    
    @Override
    public void a(final byte[] array, final byte[] array2) {
        this.a.aj = (this.a.bK & (-1 ^ this.a.aP));
        this.a.ci = (this.a.bK & (-1 ^ this.a.aj));
        this.a.m = (this.a.bs | this.a.ci);
        this.a.m &= (-1 ^ this.a.be);
        this.a.bU ^= this.a.aj;
        this.a.m ^= this.a.bU;
        this.a.cp ^= this.a.m;
        this.a.cA ^= this.a.bU;
        this.a.cA &= this.a.bC;
        this.a.cA ^= this.a.aR;
        this.a.aR = (this.a.aj ^ this.a.bs);
        this.a.aR &= this.a.be;
        this.a.aR ^= this.a.aC;
        this.a.aC = (this.a.bC & this.a.aR);
        this.a.aC ^= this.a.aR;
        this.a.aC |= this.a.am;
        this.a.aC ^= this.a.cA;
        this.a.x ^= this.a.aC;
        this.a.aC = (this.a.bs | this.a.aj);
        this.a.aC ^= this.a.bK;
        this.a.at ^= this.a.aC;
        this.a.at = (this.a.bC & (-1 ^ this.a.at));
        this.a.at ^= this.a.aN;
        this.a.at &= (-1 ^ this.a.am);
        this.a.aN = (this.a.aj & (-1 ^ this.a.bs));
        this.a.aN ^= this.a.aP;
        this.a.aN = (this.a.be & (-1 ^ this.a.aN));
        this.a.aC = (this.a.bs | this.a.aj);
        this.a.aC ^= this.a.F;
        this.a.aC = (this.a.be & (-1 ^ this.a.aC));
        this.a.C &= (-1 ^ this.a.bK);
        this.a.C ^= this.a.ar;
        this.a.J ^= this.a.C;
        this.a.bG ^= this.a.J;
        this.a.J = (this.a.bu | this.a.bG);
        this.a.J ^= this.a.bV;
        this.a.al ^= this.a.J;
        this.a.bG &= this.a.bu;
        this.a.bG ^= this.a.bV;
        this.a.ab ^= this.a.bG;
        this.a.bK ^= this.a.aP;
        this.a.bG = (this.a.bK & (-1 ^ this.a.bs));
        this.a.bG ^= this.a.aj;
        this.a.aN ^= this.a.bG;
        this.a.aN = (this.a.bC & (-1 ^ this.a.aN));
        this.a.bG = (this.a.bs | this.a.bK);
        this.a.bG ^= this.a.bK;
        this.a.aC ^= this.a.bG;
        this.a.aC &= this.a.bC;
        this.a.cc ^= this.a.bK;
        this.a.cc &= this.a.be;
        this.a.cc &= this.a.bC;
        this.a.cc ^= this.a.ci;
        this.a.cc |= this.a.am;
        this.a.cc ^= this.a.cp;
        this.a.f ^= this.a.cc;
        this.a.bs ^= this.a.bK;
        this.a.p ^= this.a.bs;
        this.a.aN ^= this.a.p;
        this.a.cC ^= this.a.aN;
        this.a.bn ^= this.a.cC;
        this.a.bn ^= -1;
        this.a.an ^= this.a.bK;
        this.a.an &= this.a.be;
        this.a.an ^= this.a.bs;
        this.a.aC ^= this.a.an;
        this.a.at ^= this.a.aC;
        this.a.bl ^= this.a.at;
        array2[0] = (byte)(0xFF & this.a.aL);
        array2[1] = (byte)((0xFF00 & this.a.aL) >>> 8);
        array2[2] = (byte)((0xFF0000 & this.a.aL) >>> 16);
        array2[3] = (byte)((0xFF000000 & this.a.aL) >>> 24);
        array2[4] = (byte)(0xFF & this.a.ce);
        array2[5] = (byte)((0xFF00 & this.a.ce) >>> 8);
        array2[6] = (byte)((0xFF0000 & this.a.ce) >>> 16);
        array2[7] = (byte)((0xFF000000 & this.a.ce) >>> 24);
        array2[8] = (byte)(0xFF & this.a.bn);
        array2[9] = (byte)((0xFF00 & this.a.bn) >>> 8);
        array2[10] = (byte)((0xFF0000 & this.a.bn) >>> 16);
        array2[11] = (byte)((0xFF000000 & this.a.bn) >>> 24);
        array2[12] = (byte)(0xFF & this.a.bd);
        array2[13] = (byte)((0xFF00 & this.a.bd) >>> 8);
        array2[14] = (byte)((0xFF0000 & this.a.bd) >>> 16);
        array2[15] = (byte)((0xFF000000 & this.a.bd) >>> 24);
        array2[16] = (byte)(0xFF & this.a.f);
        array2[17] = (byte)((0xFF00 & this.a.f) >>> 8);
        array2[18] = (byte)((0xFF0000 & this.a.f) >>> 16);
        array2[19] = (byte)((0xFF000000 & this.a.f) >>> 24);
        array2[20] = (byte)(0xFF & this.a.e);
        array2[21] = (byte)((0xFF00 & this.a.e) >>> 8);
        array2[22] = (byte)((0xFF0000 & this.a.e) >>> 16);
        array2[23] = (byte)((0xFF000000 & this.a.e) >>> 24);
        array2[24] = (byte)(0xFF & this.a.h);
        array2[25] = (byte)((0xFF00 & this.a.h) >>> 8);
        array2[26] = (byte)((0xFF0000 & this.a.h) >>> 16);
        array2[27] = (byte)((0xFF000000 & this.a.h) >>> 24);
        array2[28] = (byte)(0xFF & this.a.bC);
        array2[29] = (byte)((0xFF00 & this.a.bC) >>> 8);
        array2[30] = (byte)((0xFF0000 & this.a.bC) >>> 16);
        array2[31] = (byte)((0xFF000000 & this.a.bC) >>> 24);
        array2[32] = (byte)(0xFF & this.a.j);
        array2[33] = (byte)((0xFF00 & this.a.j) >>> 8);
        array2[34] = (byte)((0xFF0000 & this.a.j) >>> 16);
        array2[35] = (byte)((0xFF000000 & this.a.j) >>> 24);
        array2[36] = (byte)(0xFF & this.a.cw);
        array2[37] = (byte)((0xFF00 & this.a.cw) >>> 8);
        array2[38] = (byte)((0xFF0000 & this.a.cw) >>> 16);
        array2[39] = (byte)((0xFF000000 & this.a.cw) >>> 24);
        array2[40] = (byte)(0xFF & this.a.bz);
        array2[41] = (byte)((0xFF00 & this.a.bz) >>> 8);
        array2[42] = (byte)((0xFF0000 & this.a.bz) >>> 16);
        array2[43] = (byte)((0xFF000000 & this.a.bz) >>> 24);
        array2[44] = (byte)(0xFF & this.a.k);
        array2[45] = (byte)((0xFF00 & this.a.k) >>> 8);
        array2[46] = (byte)((0xFF0000 & this.a.k) >>> 16);
        array2[47] = (byte)((0xFF000000 & this.a.k) >>> 24);
        array2[48] = (byte)(0xFF & this.a.aG);
        array2[49] = (byte)((0xFF00 & this.a.aG) >>> 8);
        array2[50] = (byte)((0xFF0000 & this.a.aG) >>> 16);
        array2[51] = (byte)((0xFF000000 & this.a.aG) >>> 24);
        array2[52] = (byte)(0xFF & this.a.bD);
        array2[53] = (byte)((0xFF00 & this.a.bD) >>> 8);
        array2[54] = (byte)((0xFF0000 & this.a.bD) >>> 16);
        array2[55] = (byte)((0xFF000000 & this.a.bD) >>> 24);
        array2[56] = (byte)(0xFF & this.a.aX);
        array2[57] = (byte)((0xFF00 & this.a.aX) >>> 8);
        array2[58] = (byte)((0xFF0000 & this.a.aX) >>> 16);
        array2[59] = (byte)((0xFF000000 & this.a.aX) >>> 24);
        array2[60] = (byte)(0xFF & this.a.o);
        array2[61] = (byte)((0xFF00 & this.a.o) >>> 8);
        array2[62] = (byte)((0xFF0000 & this.a.o) >>> 16);
        array2[63] = (byte)((0xFF000000 & this.a.o) >>> 24);
        array2[64] = (byte)(0xFF & this.a.bl);
        array2[65] = (byte)((0xFF00 & this.a.bl) >>> 8);
        array2[66] = (byte)((0xFF0000 & this.a.bl) >>> 16);
        array2[67] = (byte)((0xFF000000 & this.a.bl) >>> 24);
        array2[68] = (byte)(0xFF & this.a.bc);
        array2[69] = (byte)((0xFF00 & this.a.bc) >>> 8);
        array2[70] = (byte)((0xFF0000 & this.a.bc) >>> 16);
        array2[71] = (byte)((0xFF000000 & this.a.bc) >>> 24);
        array2[72] = (byte)(0xFF & this.a.ap);
        array2[73] = (byte)((0xFF00 & this.a.ap) >>> 8);
        array2[74] = (byte)((0xFF0000 & this.a.ap) >>> 16);
        array2[75] = (byte)((0xFF000000 & this.a.ap) >>> 24);
        array2[76] = (byte)(0xFF & this.a.bb);
        array2[77] = (byte)((0xFF00 & this.a.bb) >>> 8);
        array2[78] = (byte)((0xFF0000 & this.a.bb) >>> 16);
        array2[79] = (byte)((0xFF000000 & this.a.bb) >>> 24);
        array2[80] = (byte)(0xFF & this.a.v);
        array2[81] = (byte)((0xFF00 & this.a.v) >>> 8);
        array2[82] = (byte)((0xFF0000 & this.a.v) >>> 16);
        array2[83] = (byte)((0xFF000000 & this.a.v) >>> 24);
        array2[84] = (byte)(0xFF & this.a.u);
        array2[85] = (byte)((0xFF00 & this.a.u) >>> 8);
        array2[86] = (byte)((0xFF0000 & this.a.u) >>> 16);
        array2[87] = (byte)((0xFF000000 & this.a.u) >>> 24);
        array2[88] = (byte)(0xFF & this.a.x);
        array2[89] = (byte)((0xFF00 & this.a.x) >>> 8);
        array2[90] = (byte)((0xFF0000 & this.a.x) >>> 16);
        array2[91] = (byte)((0xFF000000 & this.a.x) >>> 24);
        array2[92] = (byte)(0xFF & this.a.w);
        array2[93] = (byte)((0xFF00 & this.a.w) >>> 8);
        array2[94] = (byte)((0xFF0000 & this.a.w) >>> 16);
        array2[95] = (byte)((0xFF000000 & this.a.w) >>> 24);
        array2[96] = (byte)(0xFF & this.a.bE);
        array2[97] = (byte)((0xFF00 & this.a.bE) >>> 8);
        array2[98] = (byte)((0xFF0000 & this.a.bE) >>> 16);
        array2[99] = (byte)((0xFF000000 & this.a.bE) >>> 24);
        array2[100] = (byte)(0xFF & this.a.bN);
        array2[101] = (byte)((0xFF00 & this.a.bN) >>> 8);
        array2[102] = (byte)((0xFF0000 & this.a.bN) >>> 16);
        array2[103] = (byte)((0xFF000000 & this.a.bN) >>> 24);
        array2[104] = (byte)(0xFF & this.a.aF);
        array2[105] = (byte)((0xFF00 & this.a.aF) >>> 8);
        array2[106] = (byte)((0xFF0000 & this.a.aF) >>> 16);
        array2[107] = (byte)((0xFF000000 & this.a.aF) >>> 24);
        array2[108] = (byte)(0xFF & this.a.A);
        array2[109] = (byte)((0xFF00 & this.a.A) >>> 8);
        array2[110] = (byte)((0xFF0000 & this.a.A) >>> 16);
        array2[111] = (byte)((0xFF000000 & this.a.A) >>> 24);
        array2[112] = (byte)(0xFF & this.a.D);
        array2[113] = (byte)((0xFF00 & this.a.D) >>> 8);
        array2[114] = (byte)((0xFF0000 & this.a.D) >>> 16);
        array2[115] = (byte)((0xFF000000 & this.a.D) >>> 24);
        array2[116] = (byte)(0xFF & this.a.U);
        array2[117] = (byte)((0xFF00 & this.a.U) >>> 8);
        array2[118] = (byte)((0xFF0000 & this.a.U) >>> 16);
        array2[119] = (byte)((0xFF000000 & this.a.U) >>> 24);
        array2[120] = (byte)(0xFF & this.a.bH);
        array2[121] = (byte)((0xFF00 & this.a.bH) >>> 8);
        array2[122] = (byte)((0xFF0000 & this.a.bH) >>> 16);
        array2[123] = (byte)((0xFF000000 & this.a.bH) >>> 24);
        array2[124] = (byte)(0xFF & this.a.bh);
        array2[125] = (byte)((0xFF00 & this.a.bh) >>> 8);
        array2[126] = (byte)((0xFF0000 & this.a.bh) >>> 16);
        array2[127] = (byte)((0xFF000000 & this.a.bh) >>> 24);
        array2[128] = (byte)(0xFF & this.a.bi);
        array2[129] = (byte)((0xFF00 & this.a.bi) >>> 8);
        array2[130] = (byte)((0xFF0000 & this.a.bi) >>> 16);
        array2[131] = (byte)((0xFF000000 & this.a.bi) >>> 24);
        array2[132] = (byte)(0xFF & this.a.G);
        array2[133] = (byte)((0xFF00 & this.a.G) >>> 8);
        array2[134] = (byte)((0xFF0000 & this.a.G) >>> 16);
        array2[135] = (byte)((0xFF000000 & this.a.G) >>> 24);
        array2[136] = (byte)(0xFF & this.a.aT);
        array2[137] = (byte)((0xFF00 & this.a.aT) >>> 8);
        array2[138] = (byte)((0xFF0000 & this.a.aT) >>> 16);
        array2[139] = (byte)((0xFF000000 & this.a.aT) >>> 24);
        array2[140] = (byte)(0xFF & this.a.cm);
        array2[141] = (byte)((0xFF00 & this.a.cm) >>> 8);
        array2[142] = (byte)((0xFF0000 & this.a.cm) >>> 16);
        array2[143] = (byte)((0xFF000000 & this.a.cm) >>> 24);
        array2[144] = (byte)(0xFF & this.a.L);
        array2[145] = (byte)((0xFF00 & this.a.L) >>> 8);
        array2[146] = (byte)((0xFF0000 & this.a.L) >>> 16);
        array2[147] = (byte)((0xFF000000 & this.a.L) >>> 24);
        array2[148] = (byte)(0xFF & this.a.cl);
        array2[149] = (byte)((0xFF00 & this.a.cl) >>> 8);
        array2[150] = (byte)((0xFF0000 & this.a.cl) >>> 16);
        array2[151] = (byte)((0xFF000000 & this.a.cl) >>> 24);
        array2[152] = (byte)(0xFF & this.a.bR);
        array2[153] = (byte)((0xFF00 & this.a.bR) >>> 8);
        array2[154] = (byte)((0xFF0000 & this.a.bR) >>> 16);
        array2[155] = (byte)((0xFF000000 & this.a.bR) >>> 24);
        array2[156] = (byte)(0xFF & this.a.X);
        array2[157] = (byte)((0xFF00 & this.a.X) >>> 8);
        array2[158] = (byte)((0xFF0000 & this.a.X) >>> 16);
        array2[159] = (byte)((0xFF000000 & this.a.X) >>> 24);
        array2[160] = (byte)(0xFF & this.a.P);
        array2[161] = (byte)((0xFF00 & this.a.P) >>> 8);
        array2[162] = (byte)((0xFF0000 & this.a.P) >>> 16);
        array2[163] = (byte)((0xFF000000 & this.a.P) >>> 24);
        array2[164] = (byte)(0xFF & this.a.i);
        array2[165] = (byte)((0xFF00 & this.a.i) >>> 8);
        array2[166] = (byte)((0xFF0000 & this.a.i) >>> 16);
        array2[167] = (byte)((0xFF000000 & this.a.i) >>> 24);
        array2[168] = (byte)(0xFF & this.a.ae);
        array2[169] = (byte)((0xFF00 & this.a.ae) >>> 8);
        array2[170] = (byte)((0xFF0000 & this.a.ae) >>> 16);
        array2[171] = (byte)((0xFF000000 & this.a.ae) >>> 24);
        array2[172] = (byte)(0xFF & this.a.aa);
        array2[173] = (byte)((0xFF00 & this.a.aa) >>> 8);
        array2[174] = (byte)((0xFF0000 & this.a.aa) >>> 16);
        array2[175] = (byte)((0xFF000000 & this.a.aa) >>> 24);
        array2[176] = (byte)(0xFF & this.a.T);
        array2[177] = (byte)((0xFF00 & this.a.T) >>> 8);
        array2[178] = (byte)((0xFF0000 & this.a.T) >>> 16);
        array2[179] = (byte)((0xFF000000 & this.a.T) >>> 24);
        array2[180] = (byte)(0xFF & this.a.aP);
        array2[181] = (byte)((0xFF00 & this.a.aP) >>> 8);
        array2[182] = (byte)((0xFF0000 & this.a.aP) >>> 16);
        array2[183] = (byte)((0xFF000000 & this.a.aP) >>> 24);
        array2[184] = (byte)(0xFF & this.a.V);
        array2[185] = (byte)((0xFF00 & this.a.V) >>> 8);
        array2[186] = (byte)((0xFF0000 & this.a.V) >>> 16);
        array2[187] = (byte)((0xFF000000 & this.a.V) >>> 24);
        array2[188] = (byte)(0xFF & this.a.as);
        array2[189] = (byte)((0xFF00 & this.a.as) >>> 8);
        array2[190] = (byte)((0xFF0000 & this.a.as) >>> 16);
        array2[191] = (byte)((0xFF000000 & this.a.as) >>> 24);
        array2[192] = (byte)(0xFF & this.a.l);
        array2[193] = (byte)((0xFF00 & this.a.l) >>> 8);
        array2[194] = (byte)((0xFF0000 & this.a.l) >>> 16);
        array2[195] = (byte)((0xFF000000 & this.a.l) >>> 24);
        array2[196] = (byte)(0xFF & this.a.aJ);
        array2[197] = (byte)((0xFF00 & this.a.aJ) >>> 8);
        array2[198] = (byte)((0xFF0000 & this.a.aJ) >>> 16);
        array2[199] = (byte)((0xFF000000 & this.a.aJ) >>> 24);
        array2[200] = (byte)(0xFF & this.a.Z);
        array2[201] = (byte)((0xFF00 & this.a.Z) >>> 8);
        array2[202] = (byte)((0xFF0000 & this.a.Z) >>> 16);
        array2[203] = (byte)((0xFF000000 & this.a.Z) >>> 24);
        array2[204] = (byte)(0xFF & this.a.aD);
        array2[205] = (byte)((0xFF00 & this.a.aD) >>> 8);
        array2[206] = (byte)((0xFF0000 & this.a.aD) >>> 16);
        array2[207] = (byte)((0xFF000000 & this.a.aD) >>> 24);
        array2[208] = (byte)(0xFF & this.a.ab);
        array2[209] = (byte)((0xFF00 & this.a.ab) >>> 8);
        array2[210] = (byte)((0xFF0000 & this.a.ab) >>> 16);
        array2[211] = (byte)((0xFF000000 & this.a.ab) >>> 24);
        array2[212] = (byte)(0xFF & this.a.be);
        array2[213] = (byte)((0xFF00 & this.a.be) >>> 8);
        array2[214] = (byte)((0xFF0000 & this.a.be) >>> 16);
        array2[215] = (byte)((0xFF000000 & this.a.be) >>> 24);
        array2[216] = (byte)(0xFF & this.a.ad);
        array2[217] = (byte)((0xFF00 & this.a.ad) >>> 8);
        array2[218] = (byte)((0xFF0000 & this.a.ad) >>> 16);
        array2[219] = (byte)((0xFF000000 & this.a.ad) >>> 24);
        array2[220] = (byte)(0xFF & this.a.S);
        array2[221] = (byte)((0xFF00 & this.a.S) >>> 8);
        array2[222] = (byte)((0xFF0000 & this.a.S) >>> 16);
        array2[223] = (byte)((0xFF000000 & this.a.S) >>> 24);
        array2[224] = (byte)(0xFF & this.a.cf);
        array2[225] = (byte)((0xFF00 & this.a.cf) >>> 8);
        array2[226] = (byte)((0xFF0000 & this.a.cf) >>> 16);
        array2[227] = (byte)((0xFF000000 & this.a.cf) >>> 24);
        array2[228] = (byte)(0xFF & this.a.bF);
        array2[229] = (byte)((0xFF00 & this.a.bF) >>> 8);
        array2[230] = (byte)((0xFF0000 & this.a.bF) >>> 16);
        array2[231] = (byte)((0xFF000000 & this.a.bF) >>> 24);
        array2[232] = (byte)(0xFF & this.a.br);
        array2[233] = (byte)((0xFF00 & this.a.br) >>> 8);
        array2[234] = (byte)((0xFF0000 & this.a.br) >>> 16);
        array2[235] = (byte)((0xFF000000 & this.a.br) >>> 24);
        array2[236] = (byte)(0xFF & this.a.cs);
        array2[237] = (byte)((0xFF00 & this.a.cs) >>> 8);
        array2[238] = (byte)((0xFF0000 & this.a.cs) >>> 16);
        array2[239] = (byte)((0xFF000000 & this.a.cs) >>> 24);
        array2[240] = (byte)(0xFF & this.a.cb);
        array2[241] = (byte)((0xFF00 & this.a.cb) >>> 8);
        array2[242] = (byte)((0xFF0000 & this.a.cb) >>> 16);
        array2[243] = (byte)((0xFF000000 & this.a.cb) >>> 24);
        array2[244] = (byte)(0xFF & this.a.aE);
        array2[245] = (byte)((0xFF00 & this.a.aE) >>> 8);
        array2[246] = (byte)((0xFF0000 & this.a.aE) >>> 16);
        array2[247] = (byte)((0xFF000000 & this.a.aE) >>> 24);
        array2[248] = (byte)(0xFF & this.a.al);
        array2[249] = (byte)((0xFF00 & this.a.al) >>> 8);
        array2[250] = (byte)((0xFF0000 & this.a.al) >>> 16);
        array2[251] = (byte)((0xFF000000 & this.a.al) >>> 24);
        array2[252] = (byte)(0xFF & this.a.aK);
        array2[253] = (byte)((0xFF00 & this.a.aK) >>> 8);
        array2[254] = (byte)((0xFF0000 & this.a.aK) >>> 16);
        array2[255] = (byte)((0xFF000000 & this.a.aK) >>> 24);
    }
}
