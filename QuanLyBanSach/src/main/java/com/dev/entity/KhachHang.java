package com.dev.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "KhachHang")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ten_khach_hang", nullable = false)
	private String tenKhachHang;

	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "dia_chi")
	private String diaChi;

	@Column(name = "email", unique = true)
	private String email;

	@OneToMany(mappedBy = "khachHang")
	private Set<DonHang> donHangs;

	@OneToMany(mappedBy = "khachHang")
	private Set<HoaDon> hoaDons;

	// Getters and Setters
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<DonHang> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(Set<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

	public Set<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(Set<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}
	
}
