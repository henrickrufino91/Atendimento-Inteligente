(async function(){
  const inicio=document.querySelector('[name=inicio]')?.value, fim=document.querySelector('[name=fim]')?.value;
  const q=new URLSearchParams(); if(inicio)q.set('inicio',inicio);if(fim)q.set('fim',fim);
  const r=await fetch('/relatorios/api/periodo?'+q).then(x=>x.json());
  const labels=r.serieDiaria.map(x=>{const p=x.data.split('-');return p[2]+'/'+p[1]});
  HospitalCharts.line(document.getElementById('chartVolume'),labels,[{values:r.serieDiaria.map(x=>x.senhas)},{values:r.serieDiaria.map(x=>x.atendimentos)}]);
  HospitalCharts.doughnut(document.getElementById('chartRisco'),r.riscos.map(x=>x.nivel),r.riscos.map(x=>x.quantidade));
  HospitalCharts.bars(document.getElementById('chartProfissionais'),r.profissionais.map(x=>x.profissional),r.profissionais.map(x=>x.atendimentos));
})();
