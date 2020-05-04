<h1 align="center">
  <br>
  meta-iota <br>
  <img src="https://github.com/bernardoaraujor/meta-iota/raw/master/meta-iota.png">
  <br>
</h1>
<h3 align="center">
The OpenEmbedded layer for the <a href="https://www.iota.org/" target="_blank">IOTA Distributed Ledger</a>.
</h3>

[IOTA](https://www.iota.org/) is a revolutionary new transactional settlement and data transfer layer for the Internet of Things. It’s based on a new distributed ledger, the Tangle, which gets rid off the inefficiencies of current Blockchain designs and introduces a new way of reaching consensus in a decentralized peer-to-peer system. For the first time ever, through IOTA people can transfer money without any fees. This means that even infinitesimally small nanopayments can be made through IOTA.

IOTA is the missing puzzle piece for the Machine Economy to fully emerge and reach its desired potential. We envision IOTA to be the public, permissionless backbone for the **Internet of Things** (**IoT**) that enables true interoperability between all devices.

The [**Yocto Project**](https://www.yoctoproject.org/) is an open source collaboration project that helps developers create custom Linux-based systems regardless of the hardware architecture. Meanwhile, [**OpenEmbedded**](http://www.openembedded.org/wiki/Main_Page) is a build automation framework and cross-compile environment used to create Linux distributions for embedded devices.

Together, the Yocto Project and OpenEmbedded provide a flexible set of tools and a space where embedded developers worldwide can share technologies, software stacks, configurations, and best practices that can be used to create tailored Linux images for embedded and IoT devices, or anywhere a customized Linux OS is needed. 

The **meta-iota** OpenEmbedded Layer aims to provide recipes for IOTA related programs, tools and libraries in order to support the IOTA Tangle Ledger on a large variety of embedded devices.

The meta-iota layer is actually an umbrella layer that hosts:
 - meta-tangle: feature layer with recipes for IOTA related programs, tools and libraries for the IOTA Tangle Distributed Ledger.
 - meta-honeycomb: distro layer with configs and recipes for the IOTA honeycombOS Distribution.

Any collaborations (issues, patches, pull requests, suggestions) are more than welcome: <bernardo.araujo@iota.org>

---
## Dependencies

The meta-tangle layer depends on:

	URI: git://git.openembedded.org/openembedded-core
	layers: meta
	branch: warrior, thud, zeus

	URI: git://git.openembedded.org/meta-openembedded
	layers: meta-oe, meta-python, meta-networking
	branch: warrior, thud, zeus
	
The meta-honeycomb layer depends on:

	URI: git://git.openembedded.org/openembedded-core
	layers: meta
	branch: warrior, thud, zeus

	URI: git://git.openembedded.org/meta-openembedded
	layers: meta-oe, meta-python, meta-networking, meta-webserver
	branch: warrior, thud, zeus

	URI: git://github.com/bernardoaraujor/meta-iota
	layers: meta-tangle

---
## License

meta-iota is released under the [MIT License](https://github.com/bernardoaraujor/meta-iota/blob/master/COPYING.MIT).
