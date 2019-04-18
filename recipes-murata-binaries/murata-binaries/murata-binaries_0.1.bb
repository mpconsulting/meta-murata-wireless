SUMMARY = "Murata Binaries For Inclusion In RootFS"
DESCRIPTION = "Recipe adds murata binaries to the build"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
LICENSE = "MIT"
LIC_FILES_CHKSUM ="file://${COMMON_LICENSE_DIR}/MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI += "\
        file://etc_firmware/BCM43012C0.1LV.hcd \
        file://etc_firmware/BCM4345C0.1MW.hcd \
        file://etc_firmware/BCM4350C0.1BB.hcd \
        file://etc_firmware/BCM4354A2.1CX.hcd \
        file://lib_firmware_brcm/brcmfmac43012-sdio.bin \
        file://lib_firmware_brcm/brcmfmac43012-sdio.clm_blob \
        file://lib_firmware_brcm/brcmfmac43012-sdio.txt \
        file://lib_firmware_brcm/brcmfmac43340-sdio.bin \
        file://lib_firmware_brcm/brcmfmac43340-sdio.txt \
        file://lib_firmware_brcm/brcmfmac43362-sdio.bin \
        file://lib_firmware_brcm/brcmfmac43362-sdio.txt \
        file://lib_firmware_brcm/brcmfmac43430-sdio.bin \
        file://lib_firmware_brcm/brcmfmac43430-sdio.clm_blob \
        file://lib_firmware_brcm/brcmfmac43430-sdio.txt \
        file://lib_firmware_brcm/brcmfmac43455-sdio.bin \
        file://lib_firmware_brcm/brcmfmac43455-sdio.clm_blob \
        file://lib_firmware_brcm/brcmfmac43455-sdio.txt \
        file://lib_firmware_brcm/brcmfmac4354-sdio.bin \
        file://lib_firmware_brcm/brcmfmac4354-sdio.clm_blob \
        file://lib_firmware_brcm/brcmfmac4354-sdio.txt \
        file://lib_firmware_brcm/brcmfmac4356-pcie.bin \
        file://lib_firmware_brcm/brcmfmac4356-pcie.clm_blob \
        file://lib_firmware_brcm/brcmfmac4356-pcie.txt \
        file://lib_firmware_brcm/brcmfmac4359-pcie.bin \
        file://lib_firmware_brcm/brcmfmac4359-pcie.clm_blob \
"

#S = "${WORKDIR}"
#B = "${WORKDIR}"

DEPENDS += "\
        libnl \
"

do_compile () {
	echo "Compiling: "
        echo "Testing Make        Display:: ${MAKE}"
        echo "Testing bindir      Display:: ${bindir}"
        echo "Testing base_libdir Display:: ${base_libdir}"
        echo "Testing sysconfdir  Display:: ${sysconfdir}"
        echo "Testing S  Display:: ${S}"
        echo "Testing B  Display:: ${B}"
        echo "Testing D  Display:: ${D}"
        echo "WORK_DIR :: ${WORKDIR}"
        echo "PWD :: "
        pwd
}

do_install () {
	echo "Installing: "
	install -d ${D}/lib/firmware/brcm
	install -d ${D}/etc/firmware
	install -d ${D}/usr/sbin
	install -d ${D}/etc/udev/rules.d

	# Copying *.HCD files to etc/firmware :
	install -m 444 ${THISDIR}/files/etc_firmware/BCM4345C0.1MW.hcd ${D}${sysconfdir}/firmware/BCM4345C0.1MW.hcd
	install -m 444 ${THISDIR}/files/etc_firmware/BCM43012C0.1LV.hcd ${D}${sysconfdir}/firmware/BCM43012C0.1LV.hcd
	install -m 444 ${THISDIR}/files/etc_firmware/BCM4350C0.1BB.hcd ${D}${sysconfdir}/firmware/BCM4350C0.1BB.hcd
	install -m 444 ${THISDIR}/files/etc_firmware/BCM4354A2.1CX.hcd ${D}${sysconfdir}/firmware/BCM4354A2.1CX.hcd

	# Copying FW and CLM BLOB files (*.bin, *.clm_blob) to lib/firmware/brcm folder
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43012-sdio.bin ${D}/lib/firmware/brcm/brcmfmac43012-sdio.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43012-sdio.clm_blob ${D}/lib/firmware/brcm/brcmfmac43012-sdio.clm_blob
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43012-sdio.txt ${D}/lib/firmware/brcm/brcmfmac43012-sdio.txt
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43340-sdio.bin ${D}/lib/firmware/brcm/brcmfmac43340-sdio.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43340-sdio.txt ${D}/lib/firmware/brcm/brcmfmac43340-sdio.txt
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43362-sdio.bin ${D}/lib/firmware/brcm/brcmfmac43362-sdio.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43362-sdio.txt ${D}/lib/firmware/brcm/brcmfmac43362-sdio.txt
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43430-sdio.bin ${D}/lib/firmware/brcm/brcmfmac43430-sdio.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43430-sdio.clm_blob ${D}/lib/firmware/brcm/brcmfmac43430-sdio.clm_blob
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43430-sdio.txt ${D}/lib/firmware/brcm/brcmfmac43430-sdio.txt
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43455-sdio.bin ${D}/lib/firmware/brcm/brcmfmac43455-sdio.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43455-sdio.clm_blob ${D}/lib/firmware/brcm/brcmfmac43455-sdio.clm_blob
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac43455-sdio.txt ${D}/lib/firmware/brcm/brcmfmac43455-sdio.txt
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4354-sdio.bin ${D}/lib/firmware/brcm/brcmfmac4354-sdio.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4354-sdio.clm_blob ${D}/lib/firmware/brcm/brcmfmac4354-sdio.clm_blob
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4354-sdio.txt ${D}/lib/firmware/brcm/brcmfmac4354-sdio.txt
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4356-pcie.bin ${D}/lib/firmware/brcm/brcmfmac4356-pcie.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4356-pcie.clm_blob ${D}/lib/firmware/brcm/brcmfmac4356-pcie.clm_blob
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4356-pcie.txt ${D}/lib/firmware/brcm/brcmfmac4356-pcie.txt
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4359-pcie.bin ${D}/lib/firmware/brcm/brcmfmac4359-pcie.bin
	install -m 444 ${THISDIR}/files/lib_firmware_brcm/brcmfmac4359-pcie.clm_blob ${D}/lib/firmware/brcm/brcmfmac4359-pcie.clm_blob	
}

FILES_${PN} += "/etc/firmware"
FILES_${PN} += "/lib/firmware"
FILES_${PN} += "/lib/firmware/*"
FILES_${PN} += "${bindir}"
FILES_${PN} += "${sbindir}"
FILES_${PN} += "{sysconfdir}/firmware"
FILES_${PN} += "/lib"

INSANE_SKIP_${PN} += "build-deps"
INSANE_SKIP_${PN} += "file-rdeps"
