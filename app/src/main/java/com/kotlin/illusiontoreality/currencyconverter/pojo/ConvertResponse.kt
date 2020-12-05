package com.kotlin.illusiontoreality.currencyconverter.pojo

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose;

// Class to hold the response from currencies request.

//Used online tool to create these classes: http://www.jsonschema2pojo.org/
class ConvertResponse {

    @SerializedName("success")
    var success: Boolean = false

    @SerializedName("terms")
    var terms: String? = null

    @SerializedName("privacy")
    var privacy: String? = null

    @SerializedName("timestamp")
    var timestamp: Long = 0.toLong()

    @SerializedName("source")
    var source: String? = null

    @SerializedName("quotes")
    var quotes: Quotes? = null
}

class Quotes {

    @SerializedName("USDUSD")
    @Expose
    var uSDUSD: Double? = null

    @SerializedName("USDAED")
    @Expose
    var uSDAED: Double? = null

    @SerializedName("USDAFN")
    @Expose
    var uSDAFN: Double? = null

    @SerializedName("USDALL")
    @Expose
    var uSDALL: Double? = null

    @SerializedName("USDAMD")
    @Expose
    var uSDAMD: Double? = null

    @SerializedName("USDANG")
    @Expose
    var uSDANG: Double? = null

    @SerializedName("USDAOA")
    @Expose
    var uSDAOA: Double? = null

    @SerializedName("USDARS")
    @Expose
    var uSDARS: Double? = null

    @SerializedName("USDAUD")
    @Expose
    var uSDAUD: Double? = null

    @SerializedName("USDAWG")
    @Expose
    var uSDAWG: Double? = null

    @SerializedName("USDAZN")
    @Expose
    var uSDAZN: Double? = null

    @SerializedName("USDBAM")
    @Expose
    var uSDBAM: Double? = null

    @SerializedName("USDBBD")
    @Expose
    var uSDBBD: Double? = null

    @SerializedName("USDBDT")
    @Expose
    var uSDBDT: Double? = null

    @SerializedName("USDBGN")
    @Expose
    var uSDBGN: Double? = null

    @SerializedName("USDBHD")
    @Expose
    var uSDBHD: Double? = null

    @SerializedName("USDBIF")
    @Expose
    var uSDBIF: Double? = null

    @SerializedName("USDBMD")
    @Expose
    var uSDBMD: Double? = null

    @SerializedName("USDBND")
    @Expose
    var uSDBND: Double? = null

    @SerializedName("USDBOB")
    @Expose
    var uSDBOB: Double? = null

    @SerializedName("USDBRL")
    @Expose
    var uSDBRL: Double? = null

    @SerializedName("USDBSD")
    @Expose
    var uSDBSD: Double? = null

    @SerializedName("USDBTC")
    @Expose
    var uSDBTC: Double? = null

    @SerializedName("USDBTN")
    @Expose
    var uSDBTN: Double? = null

    @SerializedName("USDBWP")
    @Expose
    var uSDBWP: Double? = null

    @SerializedName("USDBYN")
    @Expose
    var uSDBYN: Double? = null

    @SerializedName("USDBYR")
    @Expose
    var uSDBYR: Double? = null

    @SerializedName("USDBZD")
    @Expose
    var uSDBZD: Double? = null

    @SerializedName("USDCAD")
    @Expose
    var uSDCAD: Double? = null

    @SerializedName("USDCDF")
    @Expose
    var uSDCDF: Double? = null

    @SerializedName("USDCHF")
    @Expose
    var uSDCHF: Double? = null

    @SerializedName("USDCLF")
    @Expose
    var uSDCLF: Double? = null

    @SerializedName("USDCLP")
    @Expose
    var uSDCLP: Double? = null

    @SerializedName("USDCNY")
    @Expose
    var uSDCNY: Double? = null

    @SerializedName("USDCOP")
    @Expose
    var uSDCOP: Double? = null

    @SerializedName("USDCRC")
    @Expose
    var uSDCRC: Double? = null

    @SerializedName("USDCUC")
    @Expose
    var uSDCUC: Double? = null

    @SerializedName("USDCUP")
    @Expose
    var uSDCUP: Double? = null

    @SerializedName("USDCVE")
    @Expose
    var uSDCVE: Double? = null

    @SerializedName("USDCZK")
    @Expose
    var uSDCZK: Double? = null

    @SerializedName("USDDJF")
    @Expose
    var uSDDJF: Double? = null

    @SerializedName("USDDKK")
    @Expose
    var uSDDKK: Double? = null

    @SerializedName("USDDOP")
    @Expose
    var uSDDOP: Double? = null

    @SerializedName("USDDZD")
    @Expose
    var uSDDZD: Double? = null

    @SerializedName("USDEGP")
    @Expose
    var uSDEGP: Double? = null

    @SerializedName("USDERN")
    @Expose
    var uSDERN: Double? = null

    @SerializedName("USDETB")
    @Expose
    var uSDETB: Double? = null

    @SerializedName("USDEUR")
    @Expose
    var uSDEUR: Double? = null

    @SerializedName("USDFJD")
    @Expose
    var uSDFJD: Double? = null

    @SerializedName("USDFKP")
    @Expose
    var uSDFKP: Double? = null

    @SerializedName("USDGBP")
    @Expose
    var uSDGBP: Double? = null

    @SerializedName("USDGEL")
    @Expose
    var uSDGEL: Double? = null

    @SerializedName("USDGGP")
    @Expose
    var uSDGGP: Double? = null

    @SerializedName("USDGHS")
    @Expose
    var uSDGHS: Double? = null

    @SerializedName("USDGIP")
    @Expose
    var uSDGIP: Double? = null

    @SerializedName("USDGMD")
    @Expose
    var uSDGMD: Double? = null

    @SerializedName("USDGNF")
    @Expose
    var uSDGNF: Double? = null

    @SerializedName("USDGTQ")
    @Expose
    var uSDGTQ: Double? = null

    @SerializedName("USDGYD")
    @Expose
    var uSDGYD: Double? = null

    @SerializedName("USDHKD")
    @Expose
    var uSDHKD: Double? = null

    @SerializedName("USDHNL")
    @Expose
    var uSDHNL: Double? = null

    @SerializedName("USDHRK")
    @Expose
    var uSDHRK: Double? = null

    @SerializedName("USDHTG")
    @Expose
    var uSDHTG: Double? = null

    @SerializedName("USDHUF")
    @Expose
    var uSDHUF: Double? = null

    @SerializedName("USDIDR")
    @Expose
    var uSDIDR: Double? = null

    @SerializedName("USDILS")
    @Expose
    var uSDILS: Double? = null

    @SerializedName("USDIMP")
    @Expose
    var uSDIMP: Double? = null

    @SerializedName("USDINR")
    @Expose
    var uSDINR: Double? = null

    @SerializedName("USDIQD")
    @Expose
    var uSDIQD: Double? = null

    @SerializedName("USDIRR")
    @Expose
    var uSDIRR: Double? = null

    @SerializedName("USDISK")
    @Expose
    var uSDISK: Double? = null

    @SerializedName("USDJEP")
    @Expose
    var uSDJEP: Double? = null

    @SerializedName("USDJMD")
    @Expose
    var uSDJMD: Double? = null

    @SerializedName("USDJOD")
    @Expose
    var uSDJOD: Double? = null

    @SerializedName("USDJPY")
    @Expose
    var uSDJPY: Double? = null

    @SerializedName("USDKES")
    @Expose
    var uSDKES: Double? = null

    @SerializedName("USDKGS")
    @Expose
    var uSDKGS: Double? = null

    @SerializedName("USDKHR")
    @Expose
    var uSDKHR: Double? = null

    @SerializedName("USDKMF")
    @Expose
    var uSDKMF: Double? = null

    @SerializedName("USDKPW")
    @Expose
    var uSDKPW: Double? = null

    @SerializedName("USDKRW")
    @Expose
    var uSDKRW: Double? = null

    @SerializedName("USDKWD")
    @Expose
    var uSDKWD: Double? = null

    @SerializedName("USDKYD")
    @Expose
    var uSDKYD: Double? = null

    @SerializedName("USDKZT")
    @Expose
    var uSDKZT: Double? = null

    @SerializedName("USDLAK")
    @Expose
    var uSDLAK: Double? = null

    @SerializedName("USDLBP")
    @Expose
    var uSDLBP: Double? = null

    @SerializedName("USDLKR")
    @Expose
    var uSDLKR: Double? = null

    @SerializedName("USDLRD")
    @Expose
    var uSDLRD: Double? = null

    @SerializedName("USDLSL")
    @Expose
    var uSDLSL: Double? = null

    @SerializedName("USDLTL")
    @Expose
    var uSDLTL: Double? = null

    @SerializedName("USDLVL")
    @Expose
    var uSDLVL: Double? = null

    @SerializedName("USDLYD")
    @Expose
    var uSDLYD: Double? = null

    @SerializedName("USDMAD")
    @Expose
    var uSDMAD: Double? = null

    @SerializedName("USDMDL")
    @Expose
    var uSDMDL: Double? = null

    @SerializedName("USDMGA")
    @Expose
    var uSDMGA: Double? = null

    @SerializedName("USDMKD")
    @Expose
    var uSDMKD: Double? = null

    @SerializedName("USDMMK")
    @Expose
    var uSDMMK: Double? = null

    @SerializedName("USDMNT")
    @Expose
    var uSDMNT: Double? = null

    @SerializedName("USDMOP")
    @Expose
    var uSDMOP: Double? = null

    @SerializedName("USDMRO")
    @Expose
    var uSDMRO: Double? = null

    @SerializedName("USDMUR")
    @Expose
    var uSDMUR: Double? = null

    @SerializedName("USDMVR")
    @Expose
    var uSDMVR: Double? = null

    @SerializedName("USDMWK")
    @Expose
    var uSDMWK: Double? = null

    @SerializedName("USDMXN")
    @Expose
    var uSDMXN: Double? = null

    @SerializedName("USDMYR")
    @Expose
    var uSDMYR: Double? = null

    @SerializedName("USDMZN")
    @Expose
    var uSDMZN: Double? = null

    @SerializedName("USDNAD")
    @Expose
    var uSDNAD: Double? = null

    @SerializedName("USDNGN")
    @Expose
    var uSDNGN: Double? = null

    @SerializedName("USDNIO")
    @Expose
    var uSDNIO: Double? = null

    @SerializedName("USDNOK")
    @Expose
    var uSDNOK: Double? = null

    @SerializedName("USDNPR")
    @Expose
    var uSDNPR: Double? = null

    @SerializedName("USDNZD")
    @Expose
    var uSDNZD: Double? = null

    @SerializedName("USDOMR")
    @Expose
    var uSDOMR: Double? = null

    @SerializedName("USDPAB")
    @Expose
    var uSDPAB: Double? = null

    @SerializedName("USDPEN")
    @Expose
    var uSDPEN: Double? = null

    @SerializedName("USDPGK")
    @Expose
    var uSDPGK: Double? = null

    @SerializedName("USDPHP")
    @Expose
    var uSDPHP: Double? = null

    @SerializedName("USDPKR")
    @Expose
    var uSDPKR: Double? = null

    @SerializedName("USDPLN")
    @Expose
    var uSDPLN: Double? = null

    @SerializedName("USDPYG")
    @Expose
    var uSDPYG: Double? = null

    @SerializedName("USDQAR")
    @Expose
    var uSDQAR: Double? = null

    @SerializedName("USDRON")
    @Expose
    var uSDRON: Double? = null

    @SerializedName("USDRSD")
    @Expose
    var uSDRSD: Double? = null

    @SerializedName("USDRUB")
    @Expose
    var uSDRUB: Double? = null

    @SerializedName("USDRWF")
    @Expose
    var uSDRWF: Double? = null

    @SerializedName("USDSAR")
    @Expose
    var uSDSAR: Double? = null

    @SerializedName("USDSBD")
    @Expose
    var uSDSBD: Double? = null

    @SerializedName("USDSCR")
    @Expose
    var uSDSCR: Double? = null

    @SerializedName("USDSDG")
    @Expose
    var uSDSDG: Double? = null

    @SerializedName("USDSEK")
    @Expose
    var uSDSEK: Double? = null

    @SerializedName("USDSGD")
    @Expose
    var uSDSGD: Double? = null

    @SerializedName("USDSHP")
    @Expose
    var uSDSHP: Double? = null

    @SerializedName("USDSLL")
    @Expose
    var uSDSLL: Double? = null

    @SerializedName("USDSOS")
    @Expose
    var uSDSOS: Double? = null

    @SerializedName("USDSRD")
    @Expose
    var uSDSRD: Double? = null

    @SerializedName("USDSTD")
    @Expose
    var uSDSTD: Double? = null

    @SerializedName("USDSVC")
    @Expose
    var uSDSVC: Double? = null

    @SerializedName("USDSYP")
    @Expose
    var uSDSYP: Double? = null

    @SerializedName("USDSZL")
    @Expose
    var uSDSZL: Double? = null

    @SerializedName("USDTHB")
    @Expose
    var uSDTHB: Double? = null

    @SerializedName("USDTJS")
    @Expose
    var uSDTJS: Double? = null

    @SerializedName("USDTMT")
    @Expose
    var uSDTMT: Double? = null

    @SerializedName("USDTND")
    @Expose
    var uSDTND: Double? = null

    @SerializedName("USDTOP")
    @Expose
    var uSDTOP: Double? = null

    @SerializedName("USDTRY")
    @Expose
    var uSDTRY: Double? = null

    @SerializedName("USDTTD")
    @Expose
    var uSDTTD: Double? = null

    @SerializedName("USDTWD")
    @Expose
    var uSDTWD: Double? = null

    @SerializedName("USDTZS")
    @Expose
    var uSDTZS: Double? = null

    @SerializedName("USDUAH")
    @Expose
    var uSDUAH: Double? = null

    @SerializedName("USDUGX")
    @Expose
    var uSDUGX: Double? = null

    @SerializedName("USDUYU")
    @Expose
    var uSDUYU: Double? = null

    @SerializedName("USDUZS")
    @Expose
    var uSDUZS: Double? = null

    @SerializedName("USDVEF")
    @Expose
    var uSDVEF: Double? = null

    @SerializedName("USDVND")
    @Expose
    var uSDVND: Double? = null

    @SerializedName("USDVUV")
    @Expose
    var uSDVUV: Double? = null

    @SerializedName("USDWST")
    @Expose
    var uSDWST: Double? = null

    @SerializedName("USDXAF")
    @Expose
    var uSDXAF: Double? = null

    @SerializedName("USDXAG")
    @Expose
    var uSDXAG: Double? = null

    @SerializedName("USDXAU")
    @Expose
    var uSDXAU: Double? = null

    @SerializedName("USDXCD")
    @Expose
    var uSDXCD: Double? = null

    @SerializedName("USDXDR")
    @Expose
    var uSDXDR: Double? = null

    @SerializedName("USDXOF")
    @Expose
    var uSDXOF: Double? = null

    @SerializedName("USDXPF")
    @Expose
    var uSDXPF: Double? = null

    @SerializedName("USDYER")
    @Expose
    var uSDYER: Double? = null

    @SerializedName("USDZAR")
    @Expose
    var uSDZAR: Double? = null

    @SerializedName("USDZMK")
    @Expose
    var uSDZMK: Double? = null

    @SerializedName("USDZMW")
    @Expose
    var uSDZMW: Double? = null

    @SerializedName("USDZWL")
    @Expose
    var uSDZWL: Double? = null

}