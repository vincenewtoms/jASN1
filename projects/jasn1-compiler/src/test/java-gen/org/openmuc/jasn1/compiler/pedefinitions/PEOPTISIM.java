/**
 * This class file was automatically generated by jASN1 v1.7.1 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.pedefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class PEOPTISIM {

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public PEHeader optisimHeader = null;
	public BerObjectIdentifier templateID = null;
	public File efPcscf = null;
	public File efSms = null;
	public File efSmsp = null;
	public File efSmss = null;
	public File efSmsr = null;
	public File efGbabp = null;
	public File efGbanl = null;
	public File efNafkca = null;
	public File efUicciari = null;
	
	public PEOPTISIM() {
	}

	public PEOPTISIM(byte[] code) {
		this.code = code;
	}

	public PEOPTISIM(PEHeader optisimHeader, BerObjectIdentifier templateID, File efPcscf, File efSms, File efSmsp, File efSmss, File efSmsr, File efGbabp, File efGbanl, File efNafkca, File efUicciari) {
		this.optisimHeader = optisimHeader;
		this.templateID = templateID;
		this.efPcscf = efPcscf;
		this.efSms = efSms;
		this.efSmsp = efSmsp;
		this.efSmss = efSmss;
		this.efSmsr = efSmsr;
		this.efGbabp = efGbabp;
		this.efGbanl = efGbanl;
		this.efNafkca = efNafkca;
		this.efUicciari = efUicciari;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {
		return encode(os, true);
	}

	public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (efUicciari != null) {
			codeLength += efUicciari.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 10
			os.write(0xAA);
			codeLength += 1;
		}
		
		if (efNafkca != null) {
			codeLength += efNafkca.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 9
			os.write(0xA9);
			codeLength += 1;
		}
		
		if (efGbanl != null) {
			codeLength += efGbanl.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
			os.write(0xA8);
			codeLength += 1;
		}
		
		if (efGbabp != null) {
			codeLength += efGbabp.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 7
			os.write(0xA7);
			codeLength += 1;
		}
		
		if (efSmsr != null) {
			codeLength += efSmsr.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
			os.write(0xA6);
			codeLength += 1;
		}
		
		if (efSmss != null) {
			codeLength += efSmss.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			os.write(0xA5);
			codeLength += 1;
		}
		
		if (efSmsp != null) {
			codeLength += efSmsp.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			os.write(0xA4);
			codeLength += 1;
		}
		
		if (efSms != null) {
			codeLength += efSms.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			os.write(0xA3);
			codeLength += 1;
		}
		
		if (efPcscf != null) {
			codeLength += efPcscf.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			os.write(0xA2);
			codeLength += 1;
		}
		
		codeLength += templateID.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		os.write(0x81);
		codeLength += 1;
		
		codeLength += optisimHeader.encode(os, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
		os.write(0xA0);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(os, codeLength);

		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		if (totalLength == -1) {
			subCodeLength += berTag.decode(is);

			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
				optisimHeader = new PEHeader();
				subCodeLength += optisimHeader.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
				templateID = new BerObjectIdentifier();
				subCodeLength += templateID.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
				efPcscf = new File();
				subCodeLength += efPcscf.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
				efSms = new File();
				subCodeLength += efSms.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
				efSmsp = new File();
				subCodeLength += efSmsp.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
				efSmss = new File();
				subCodeLength += efSmss.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
				efSmsr = new File();
				subCodeLength += efSmsr.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
				efGbabp = new File();
				subCodeLength += efGbabp.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 8)) {
				efGbanl = new File();
				subCodeLength += efGbanl.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 9)) {
				efNafkca = new File();
				subCodeLength += efNafkca.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 10)) {
				efUicciari = new File();
				subCodeLength += efUicciari.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			int nextByte = is.read();
			if (berTag.tagNumber != 0 || berTag.tagClass != 0 || berTag.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			optisimHeader = new PEHeader();
			subCodeLength += optisimHeader.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			templateID = new BerObjectIdentifier();
			subCodeLength += templateID.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
			efPcscf = new File();
			subCodeLength += efPcscf.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			efSms = new File();
			subCodeLength += efSms.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
			efSmsp = new File();
			subCodeLength += efSmsp.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			efSmss = new File();
			subCodeLength += efSmss.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
			efSmsr = new File();
			subCodeLength += efSmsr.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
			efGbabp = new File();
			subCodeLength += efGbabp.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 8)) {
			efGbanl = new File();
			subCodeLength += efGbanl.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 9)) {
			efNafkca = new File();
			subCodeLength += efNafkca.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 10)) {
			efUicciari = new File();
			subCodeLength += efUicciari.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("optisimHeader: ").append(optisimHeader);
		
		sb.append(", ");
		sb.append("templateID: ").append(templateID);
		
		if (efPcscf != null) {
			sb.append(", ");
			sb.append("efPcscf: ").append(efPcscf);
		}
		
		if (efSms != null) {
			sb.append(", ");
			sb.append("efSms: ").append(efSms);
		}
		
		if (efSmsp != null) {
			sb.append(", ");
			sb.append("efSmsp: ").append(efSmsp);
		}
		
		if (efSmss != null) {
			sb.append(", ");
			sb.append("efSmss: ").append(efSmss);
		}
		
		if (efSmsr != null) {
			sb.append(", ");
			sb.append("efSmsr: ").append(efSmsr);
		}
		
		if (efGbabp != null) {
			sb.append(", ");
			sb.append("efGbabp: ").append(efGbabp);
		}
		
		if (efGbanl != null) {
			sb.append(", ");
			sb.append("efGbanl: ").append(efGbanl);
		}
		
		if (efNafkca != null) {
			sb.append(", ");
			sb.append("efNafkca: ").append(efNafkca);
		}
		
		if (efUicciari != null) {
			sb.append(", ");
			sb.append("efUicciari: ").append(efUicciari);
		}
		
		sb.append("}");
		return sb.toString();
	}

}
