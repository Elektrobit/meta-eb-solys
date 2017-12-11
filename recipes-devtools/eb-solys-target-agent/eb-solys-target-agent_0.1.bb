DESCRIPTION = "EB RACE Target Agent"
HOMEPAGE = "http://automotive.elektrobit.com"
LICENSE = "CLOSED"
PR = "r0"


DEPENDS = "protobuf protobuf-native poco"

inherit cmake pkgconfig 

SRC_URI = "git://github.com/Elektrobit/eb-solys-target-agent-yocto.git;branch=master"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

INSANE_SKIP_${PN} += "rpaths" 

EXTRA_OECMAKE += " -DTA_PLUGIN_socket-reader-plugin=true -DTA_PLUGIN_resource-monitor-plugin=true -DCMAKE_BUILD_TYPE=Release -DCMAKE_TOOLCHAIN_FILE=${WORKDIR}/toolchain.cmake -DCMAKE_PREFIX_PATH=${STAGING_DIR_TARGET} -DCMAKE_SYSROOT_PATH=${STAGING_DIR_TARGET} -DCMAKE_INSTALL_PREFIX=/opt/eb-solys"


FILES_${PN} += "/opt/eb-solys"
FILES_${PN}-dbg += "/opt/eb-solys/.debug"
